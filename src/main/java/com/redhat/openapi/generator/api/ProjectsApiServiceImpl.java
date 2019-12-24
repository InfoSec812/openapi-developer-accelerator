package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class ProjectsApiServiceImpl implements ProjectsApiService {
  @Override
  public Response createProject(Project project, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response deleteProject(String projectId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getProject(String projectId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getprojects(SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response updateProject(String projectId, Project project, SecurityContext securityContext) throws NotFoundException {
    return null;
  }
}
