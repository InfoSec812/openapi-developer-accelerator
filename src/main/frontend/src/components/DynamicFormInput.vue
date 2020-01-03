<template>
  <div class="col-grow">
    <q-input :value="value" dense stack-label
             v-if="optionInputType(option, 'string')"
             :label="option.description" hide-hint @input="update"
             :hint="option.defaultValue" class="row" />
    <q-checkbox :value="value" :toggle-indeterminate="false" @input="update"
                v-if="optionInputType(option, 'boolean')" class="row"
                :label="option.description" dense ref="checkbox" />
    <q-select :value="value" stack-label dense :options-dense="false"
              :label="option.description" emit-value @input="update"
              v-if="optionInputType(option, 'enum')" map-options
              class="row" :options="enumOptionsObject(option)" />
  </div>
</template>

<script>
export default {
  props: ['option', 'value'],
  methods: {
    optionInputType(option, desiredType) {
      switch (desiredType) {
        case 'enum':
          return (typeof option.enum !== 'undefined' && option.enum !== null);
        case 'string':
          return ((typeof option.enum === 'undefined' || option.enum === null) && option.type === 'string');
        case 'boolean':
          return ((typeof option.enum === 'undefined' || option.enum === null) && option.type === 'boolean');
        default:
          return option.type === desiredType;
      }
    },
    update(newValue) {
      this.$emit('input', newValue);
    },
    enumOptionsObject(option) {
      return Object.entries(option.enum)
        .map(([key, value]) => ({ label: value, value: key, description: value }));
    },
  },
};
</script>
