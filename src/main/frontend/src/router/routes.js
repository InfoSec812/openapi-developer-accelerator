
const routes = [
  {
    path: '/',
    component: () => import('layouts/MyLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: '/config', component: () => import('pages/Config.vue') },
      { path: '/project/:projectName', component: () => import('pages/Project.vue') },
      { path: '/project/:projectName/implementation/:implementationName', component: () => import('pages/Implementation.vue') },
    ],
  },
];

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue'),
  });
}

export default routes;
