package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class ProjectsApiServiceImpl implements ProjectsApiService {

  @Override
  @Transactional
  public Response createProject(Project project, SecurityContext securityContext) throws NotFoundException {
    project.persistAndFlush();
    return Response.ok(project).build();
  }

  @Override
  @Transactional
  public Response deleteProject(String projectId, SecurityContext securityContext) throws NotFoundException {
    Project.find("FROM Project WHERE projectid = ?", projectId).firstResult().delete();
    return Response.noContent().build();
  }

  @Override
  public Response getProject(String projectId, SecurityContext securityContext) throws NotFoundException {
    Project requested = Project.find("FROM Project WHERE projectid = ?", projectId).firstResult();
    return Response.ok(requested).build();
  }

  @Override
  public Response getprojects(SecurityContext securityContext) throws NotFoundException {
    return Response.ok(Project.listAll()).build();
  }

  @Override
  @Transactional
  public Response updateProject(String projectId, Project project, SecurityContext securityContext) throws NotFoundException {
    Project existing = Project.find("FROM Project WHERE projectid = ?", projectId).firstResult();
    existing.setDescription(project.getDescription());
    existing.setName(project.getName());
    existing.setOwner(project.getOwner());
    existing.setSpecification(project.getSpecification());
    existing.persist();
    return Response.ok(existing).build();
  }
}
