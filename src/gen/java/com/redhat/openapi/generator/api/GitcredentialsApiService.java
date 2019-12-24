package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.api.*;
import com.redhat.openapi.generator.models.*;


import com.redhat.openapi.generator.models.GitCredential;

import java.util.List;
import com.redhat.openapi.generator.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public interface GitcredentialsApiService {
      Response createGitCredential(GitCredential gitCredential,SecurityContext securityContext)
      throws NotFoundException;
      Response deleteGitCredential(String gitcredentialId,SecurityContext securityContext)
      throws NotFoundException;
      Response getGitCredential(String gitcredentialId,SecurityContext securityContext)
      throws NotFoundException;
      Response getgitcredentials(SecurityContext securityContext)
      throws NotFoundException;
      Response updateGitCredential(String gitcredentialId,GitCredential gitCredential,SecurityContext securityContext)
      throws NotFoundException;
}
