package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.GitCredential;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class GitcredentialsApiServiceImpl implements GitcredentialsApiService {
  @Override
  public Response createGitCredential(GitCredential gitCredential, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response deleteGitCredential(String gitcredentialId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getGitCredential(String gitcredentialId, SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response getgitcredentials(SecurityContext securityContext) throws NotFoundException {
    return null;
  }

  @Override
  public Response updateGitCredential(String gitcredentialId, GitCredential gitCredential, SecurityContext securityContext) throws NotFoundException {
    return null;
  }
}
