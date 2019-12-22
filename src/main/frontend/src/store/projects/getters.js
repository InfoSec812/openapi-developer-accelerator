/*
export function someGetter (state) {
}
*/
export function getProjectList(state) {
  return state.projects.map(proj => proj.name);
}

export function getProject(state, name) {
  return state.projects[name];
}
