<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          @click="leftDrawerOpen = !leftDrawerOpen"
          icon="menu"
          aria-label="Menu"
        />

        <q-toolbar-title>
          Developer Accelerator
        </q-toolbar-title>

        <div>Version 0.0.1</div>
        <q-btn flat dense round @click="$router.push('/config')" icon="settings" />
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-2"
    >
      <q-list>
        <q-item v-for="project in projectList" :key="project.id">
          <q-item-label @click="openProject(project.id)">{{ project.name }}</q-item-label>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8081';

export default {
  name: 'MyLayout',

  data() {
    return {
      leftDrawerOpen: false,
    };
  },
  computed: {
    projectList: {
      get() {
        return this.$store.state.projects.projects;
      },
    },
  },
  methods: {
    openProject(projectId) {
      this.$router.push(`/project/${projectId}`);
    },
  },
  mounted() {
    // axios.get('/project')
    //   .then(res => this.$store.commit('projects/loadProjectList', res.data))
    //   .catch(err => console.log(err));
    axios.get('/generator')
      .then(res => this.$store.commit('projects/loadGeneratorsList', res.data))
      .catch(err => console.log(err));
  },
};
</script>
