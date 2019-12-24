package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.api.*;
import com.redhat.openapi.generator.models.*;


import com.redhat.openapi.generator.models.Project;

import java.util.List;
import com.redhat.openapi.generator.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public interface ProjectsApiService {
      Response createProject(Project project,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteProject(String projectId,SecurityContext securityContext)
      throws NotFoundException;
      Response getProject(String projectId,SecurityContext securityContext)
      throws NotFoundException;
      Response getprojects(SecurityContext securityContext)
      throws NotFoundException;
      Response updateProject(String projectId,Project project,SecurityContext securityContext)
      throws NotFoundException;
}
