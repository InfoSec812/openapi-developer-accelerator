<template>
  <q-page padding>
    <div class="row">
      <span class="col">Project Name:</span>
      <span class="minInput, col-grow">{{ project.name }}</span>
      <q-popup-edit v-model="project.name" :cover="false" :offset="[-60, 10]">
        <q-input v-model="project.name" dense/>
      </q-popup-edit>
    </div>
    <div class="col">
      <span class="col">Project Description:</span>
      <span class="minInput, col-grow">{{ project.description }}</span>
      <q-popup-edit v-model="project.description" :cover="false" :offset="[-60, 10]">
        <q-input v-model="project.description" type="textarea" filled/>
      </q-popup-edit>
    </div>
  </q-page>
</template>

<style>
.minInput {
  min-width: 200px;
  min-height: 40px;
  border-bottom: 2px solid black;
}
</style>

<script>
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8086/api/v1';

export default {
  data() {
    return {
      project: {
        name: '',
        description: '',
        specification: '',
        created: new Date(),
        owner: '',
      },
    };
  },
  mounted() {
    if (this.$route.params.projectId !== 'new') {
      axios.get(`/projects/${this.$route.params.projectId}`)
        .then((res) => {
          this.$data.project = res.data;
        }).catch(err => console.log(err));
    }
  },
};
</script>
