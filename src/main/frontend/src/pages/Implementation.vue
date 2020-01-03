<template>
  <q-page padding class="col">
    Implementation {{ generatorName }}

    <q-option-group class="row"
                    :options="implTypeOptions"
                    label="Implementation Types"
                    type="checkbox"
                    v-model="implTypeFilters" />
    <q-option-group class="row"
                    :options="implStatusOptions"
                    label="Implementation Statuses"
                    type="checkbox"
                    v-model="implStatusFilters" />
    <div class="row">
      <q-select filled v-model="generatorName" class="col-grow"
                :options="generatorNames" stack-label label="Generator"
                @input="updateGeneratorConfigs" emit-value map-options>
        <template v-slot:option="scope">
          <q-item v-on="scope.itemEvents" :style="scope.opt.color"
                  v-bind="scope.itemProps">
            <q-item-section no-wrap style="max-width: 10em;">
              <q-item-label caption>{{ scope.opt.category }}</q-item-label>
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
      <q-item v-for="opt in reccommendedOptions" :key="opt.opt">
        <dynamic-form-input v-model="config[opt.opt]" :option="opt" />
      </q-item>
      <q-expansion-item>
        <template v-slot:header>
          <div class="advancedOptions col-grow">
            Advanced Options
          </div>
        </template>
        <q-item v-for="opt in advOptions" :key="opt.opt">
          <dynamic-form-input v-model="config[opt.opt]" :option="opt" />
        </q-item>
      </q-expansion-item>
    </q-list>
  </q-page>
</template>

<style lang="scss">
.paddedRow {
  padding-bottom: 20px;
}
.advancedOptions {
  size: 7em;
  font-weight: bold;
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
      implTypeFilters: ['CLIENT', 'SERVER'],
      implTypeOptions: [
        { label: 'Clients', value: 'CLIENT' },
        { label: 'Servers', value: 'SERVER' },
        { label: 'Documentation', value: 'DOCUMENTATION' },
        { label: 'Configurations', value: 'CONFIG' },
        { label: 'Schema', value: 'SCHEMA' },
      ],
      implStatusFilters: ['STABLE', 'BETA'],
      implStatusOptions: [
        { label: 'Stable', value: 'STABLE', color: 'green' },
        { label: 'Beta', value: 'BETA', color: 'yellow' },
        { label: 'Experimental', value: 'EXPERIMENTAL', color: 'blue' },
        { label: 'Deprecated', value: 'DEPRECATED', color: 'red' },
      ],
    };
  },
  computed: {
    reccommendedOptions: {
      get() {
        return this.$data.genOpts.filter(opt => !opt.advanced);
      },
    },
    advOptions: {
      get() {
        return this.$data.genOpts.filter(opt => opt.advanced);
      },
    },
    generatorList: {
      get() {
        return this.$store.state.projects.generators;
      },
    },
    generatorNames: {
      get() {
        return this.generatorList.map((g) => {
          const retVal = {
            label: g.name, value: g.name, description: g.help, category: g.tag,
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
        }).filter((g) => {
          console.log(`Checking if '${g.category}' is in list '${this.$data.implTypeFilters}'`);
          return this.$data.implTypeFilters.includes(g.category.toUpperCase());
        }).filter((g) => {
          console.log(`Checking if '${g.status}' is in list '${this.$data.implStatusFilters}'`);
          return this.$data.implStatusFilters.includes(g.status.toUpperCase());
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
          this.$data.config = {};
          this.$data.genOpts = [];
          // Since we are dynamically defining the options based on the generator, we
          // have to let Vue know about each element so that it can set them up to be
          // reactive.
          res.data.forEach((opt) => {
            if (typeof this.$data.config[opt.opt] === 'undefined') {
              if (opt.type === 'boolean') {
                const boolVal = (typeof opt.default === 'undefined' || opt.default === null) ? null : opt.default === 'true';
                this.$set(this.$data.config, opt.opt, boolVal);
                this.$data.genOpts.push(opt);
              } else {
                const newVal = (typeof opt.default === 'undefined' || opt.default === null) ? null : opt.default;
                this.$set(this.$data.config, opt.opt, newVal);
                this.$data.genOpts.push(opt);
              }
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
