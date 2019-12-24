<template>
  <q-page padding class="col">
    Implementation {{ generatorName }}

    <div class="row">
      <q-select filled v-model="generatorName" class="col-grow"
                :options="generatorNames" stack-label label="Generator"
                @input="updateGeneratorConfigs" />
      <q-icon name="help" class="col-1" size="40px">
        <q-tooltip>
          {{ descriptionForGenerator }}
        </q-tooltip>
      </q-icon>
    </div>
    <q-list>
      <q-item v-for="opt in genOpts" :key="opt.option">
        <q-item-section avatar>
          <q-icon name="help" size="20px" >
            <q-tooltip>{{ opt.help }}</q-tooltip>
          </q-icon>
        </q-item-section>
        <q-item-section>
          <dynamic-form-input v-model="config[opt.option]" :option="opt" />
        </q-item-section>
      </q-item>
    </q-list>
  </q-page>
</template>

<style lang="scss">
.paddedRow {
  padding-bottom: 20px;
}
</style>

<script>
import axios from 'axios';
import DynamicFormInput from '../components/DynamicFormInput';

axios.defaults.baseURL = 'http://localhost:8081';

export default {
  components: { DynamicFormInput },
  data() {
    return {
      generatorName: '',
      genOpts: [],
      config: {},
    };
  },
  watch: {
    config: {
      deep: true,
      handler() {
        if (this.$data.config.dateLibrary === 'java8' || this.$data.config.dateLibrary === 'java8-localdatetime') {
          this.$data.config.java8 = true;
        }
      },
    },
  },
  computed: {
    generatorList: {
      get() {
        return this.$store.state.projects.generators;
      },
    },
    generatorNames: {
      get() {
        return this.generatorList.map(g => g.name);
      },
    },
    descriptionForGenerator: {
      get() {
        return this.generatorList.find(g => g.name === this.$data.generatorName).description;
      },
    },
  },
  methods: {
    updateGeneratorConfigs() {
      axios.get(`/generator/${this.$data.generatorName}`)
        .then((res) => {
          this.$data.genOpts = res.data;
        })
        .catch(err => console.log(err));
    },
  },
  mounted() {
    console.log(`Requesting: /generator/${this.$route.params.implementationName}`);
    this.$data.generatorName = this.$route.params.implementationName;
    this.updateGeneratorConfigs();
  },
};
</script>
