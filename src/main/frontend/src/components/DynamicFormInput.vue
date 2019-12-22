<template>
  <div class="col-grow">
    <q-input :value="value" dense stack-label @input="updateValue"
             v-if="option.optionType === 'string'" :label="option.description" hide-hint
             :hint="option.defaultValue" class="row" />
    <q-checkbox :value="defaultedValue" :toggle-indeterminate="false"
                v-if="option.optionType === 'boolean'" class="row"
                :label="option.description" dense @input="updateValue" />
    <q-select :value="value" stack-label dense :options-dense="false"
              :label="option.description" @input="updateEnum"
              v-if="option.optionType === 'enum'" class="row"
              :options="option.enumValues" />
  </div>
</template>

<script>
export default {
  props: ['option', 'value'],
  computed: {
    defaultedValue() { // If the `value` is null or undefined, replace it with the defaultValue
      if (this.$props.value === null || typeof this.$props.value === 'undefined') {
        if (this.$props.option.optionType === 'boolean') {
          return this.$props.option.defaultValue;
        }
      }
      return this.$props.value;
    },
  },
  methods: {
    updateEnum(newValue) {
      console.log(`Emitting: ${newValue.value}`);
      this.$emit('input', newValue.value);
    },
    updateValue(newValue) {
      console.log(`Emitting: ${newValue.value}`);
      const updatedValue = newValue === '' ? null : newValue;
      this.$emit('input', updatedValue);
    },
  },
};
</script>
