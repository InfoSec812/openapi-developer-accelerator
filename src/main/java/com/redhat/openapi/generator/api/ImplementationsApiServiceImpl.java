package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Implementation;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class ImplementationsApiServiceImpl implements ImplementationsApiService {
  @Override
  @Transactional
  public Response createImplementation(Implementation implementation, SecurityContext securityContext) throws NotFoundException {
    implementation.persistAndFlush();
    return Response.ok(implementation).build();
  }

  @Override
  @Transactional
  public Response deleteImplementation(String implementationId, SecurityContext securityContext) throws NotFoundException {
    Implementation.find("FROM Implementation WHERE implementationId = ?", implementationId).firstResult().delete();
    return Response.noContent().build();
  }

  @Override
  public Response getImplementation(String implementationId, SecurityContext securityContext) throws NotFoundException {
    Implementation requested = Implementation.find("FROM Implementation WHERE implementationId = ?", implementationId).firstResult();
    return Response.ok(requested).build();
  }

  @Override
  public Response getimplementations(SecurityContext securityContext) throws NotFoundException {
    return Response.ok(Implementation.listAll()).build();
  }

  @Override
  @Transactional
  public Response updateImplementation(String implementationId, Implementation implementation, SecurityContext securityContext) throws NotFoundException {
    Implementation existing = Implementation.find("FROM Implementation WHERE implementationId = ?", implementationId).firstResult();
    existing.setConfiguration(implementation.getConfiguration());
    existing.setCustomizeTemplates(implementation.isCustomizeTemplates());
    existing.setGitUrl(implementation.getGitUrl());
    existing.setImplementation(implementation.getImplementation());
    existing.setName(implementation.getName());
    existing.setProjectId(implementation.getProjectId());
    existing.persistAndFlush();
    return Response.ok(existing).build();
  }
}
