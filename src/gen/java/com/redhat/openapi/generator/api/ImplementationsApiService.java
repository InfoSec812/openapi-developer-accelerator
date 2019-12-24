package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.api.*;
import com.redhat.openapi.generator.models.*;


import com.redhat.openapi.generator.models.Implementation;

import java.util.List;
import com.redhat.openapi.generator.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public interface ImplementationsApiService {
      Response createImplementation(Implementation implementation,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteImplementation(String implementationId,SecurityContext securityContext)
      throws NotFoundException;
      Response getImplementation(String implementationId,SecurityContext securityContext)
      throws NotFoundException;
      Response getimplementations(SecurityContext securityContext)
      throws NotFoundException;
      Response updateImplementation(String implementationId,Implementation implementation,SecurityContext securityContext)
      throws NotFoundException;
}
