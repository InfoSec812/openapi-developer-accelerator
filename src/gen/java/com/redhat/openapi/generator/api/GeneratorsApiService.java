package com.redhat.openapi.generator.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public interface GeneratorsApiService {
      Response getgeneratoroptions(String name,SecurityContext securityContext)
      throws NotFoundException;
      Response getgenerators(SecurityContext securityContext)
      throws NotFoundException;
}
