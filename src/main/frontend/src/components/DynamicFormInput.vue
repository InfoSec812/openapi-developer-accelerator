<template>
  <div class="col-grow">
    <q-input :value="defaultedValue" dense stack-label @input="updateValue"
             v-if="optionInputType(option, 'string')"
             :label="option.description" hide-hint
             :hint="option.defaultValue" class="row" />
    <q-checkbox :value="defaultedValue" :toggle-indeterminate="false"
                v-if="optionInputType(option, 'boolean')" class="row"
                :label="option.description" dense @input="updateValue" />
    <q-select :value="defaultedValue" stack-label dense :options-dense="false"
              :label="option.description" @input="updateValue" emit-value
              v-if="optionInputType(option, 'enum')" map-options
              class="row" :options="enumOptionsObject(option)" />
  </div>
</template>

<script>
export default {
  props: ['option', 'value'],
  computed: {
    defaultedValue() { // If the `value` is null or undefined, replace it with the defaultValue
      if (typeof this.$props.value === 'undefined') {
        console.log(`Option ${this.$props.option.opt} is undefined`);
      }
      if (!this.optionInputType(this.$props.option, 'string') && this.$props.value === 'undefined') {
        return this.$props.option.default;
      }
      return this.$props.value;
    },
  },
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
    updateValue(newValue) {
      const updatedValue = newValue === '' ? null : newValue;
      this.$emit('input', updatedValue);
    },
    enumOptionsObject(option) {
      return Object.entries(option.enum)
        .map(([key, value]) => ({ label: value, value: key, description: value }));
    },
  },
};
</script>
