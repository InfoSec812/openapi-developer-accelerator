import yaml from 'js-yaml';

export function newProject(state, project) {
  state.projects[project.id] = project;
}

export function setApiSpec(state, name, apiSpec) {
  state.projects[name].spec = yaml.safeLoad(apiSpec);
}

export function addTarget(state, projectId, target) {
  state.projects[projectId].targets.push(target);
}

export async function loadGeneratorsList(state, generatorList) {
  state.generators = generatorList;
}

export function loadProjectList(state, projectList) {
  state.projects = projectList;
}
