package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Implementation;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class ImplementationsApiServiceImpl implements ImplementationsApiService {
  @Override
  public Response createImplementation(Implementation implementation, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response deleteImplementation(String implementationId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getImplementation(String implementationId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getimplementations(SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response updateImplementation(String implementationId, Implementation implementation, SecurityContext securityContext) throws NotFoundException {
    return null;
  }
}
