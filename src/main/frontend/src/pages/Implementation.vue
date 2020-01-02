<template>
  <q-page padding class="col">
    Implementation {{ generatorName }}

    <div class="row">
      <q-select filled v-model="generatorName" class="col-grow"
                :options="generatorNames" stack-label label="Generator"
                @input="updateGeneratorConfigs" emit-value map-options>
        <template v-slot:option="scope">
          <q-item v-on="scope.itemEvents" :style="scope.opt.color"
                  v-bind="scope.itemProps">
            <q-item-section no-wrap style="max-width: 10em;">
              <q-item-label caption>{{ scope.opt.tag }}</q-item-label>
            </q-item-section>
            <q-item-section class="col-grow">
              <q-item-label>{{ scope.opt.label }}</q-item-label>
            </q-item-section>
            <q-item-section no-wrap style="max-width: 6em; text-align: right;">
              <q-item-label caption>{{ scope.opt.status }}</q-item-label>
            </q-item-section>
          </q-item>
        </template>
      </q-select>
      <q-icon name="help" class="col-1" size="40px">
        <q-tooltip>
          {{ descriptionForGenerator }}
        </q-tooltip>
      </q-icon>
    </div>
    <q-list>
      <q-item v-for="opt in genOpts" :key="opt.option">
<!--        <q-item-section avatar>-->
<!--          <q-icon name="help" size="20px" >-->
<!--            <q-tooltip>{{ opt.description }}</q-tooltip>-->
<!--          </q-icon>-->
<!--        </q-item-section>-->
        <q-item-section>
          <dynamic-form-input v-model="config[opt.opt]" :option="opt" />
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
import jsonPath from 'jsonpath';
import DynamicFormInput from '../components/DynamicFormInput';

axios.defaults.baseURL = 'http://localhost:8086/api/v1';

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
        return this.generatorList.map((g) => {
          const retVal = {
            label: g.name, value: g.name, description: g.help, tag: g.tag,
          };
          switch (g.generatorMetadata.stability) {
            case 'BETA':
              retVal.color = 'background-color: rgba(255, 255, 0, 0.4);';
              retVal.status = 'BETA';
              break;
            case 'DEPRECATED':
              retVal.color = 'background-color: rgba(255, 0, 0, 0.2);';
              retVal.status = 'DEPRECATED';
              break;
            case 'EXPERIMENTAL':
              retVal.color = 'background-color: rgba(0, 0, 255, 0.4);';
              retVal.status = 'EXPERIMENTAL';
              break;
            default:
              retVal.color = 'background-color: rgba(0, 255, 0, 0.3);';
              retVal.status = 'STABLE';
          }
          return retVal;
        });
      },
    },
    descriptionForGenerator: {
      get() {
        const { generatorName } = this.$data;
        return jsonPath.query(this.generatorList, `$[?(@.name == '${generatorName}')].help`)[0];
      },
    },
  },
  methods: {
    updateGeneratorConfigs() {
      axios.get(`/generators/${this.$data.generatorName}`)
        .then((res) => {
          this.$data.genOpts = res.data;
          res.data.forEach((opt) => {
            if (typeof this.$data.config[opt.opt] === 'undefined') {
              this.$data.config[opt.opt] = (typeof opt.default === 'undefined' || opt.default === null) ? null : opt.default;
            }
          });
        })
        .catch(err => console.log(err));
    },
  },
  mounted() {
    console.log(`Requesting: /generators/${this.$route.params.implementationName}`);
    this.$data.generatorName = this.$route.params.implementationName;
    this.updateGeneratorConfigs();
  },
};
</script>
