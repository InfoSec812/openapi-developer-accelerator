package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.GitCredential;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/gitcredentials")


@io.swagger.annotations.Api(description = "the gitcredentials API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public class GitcredentialsApi  {

    @Inject GitcredentialsApiService service;

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Create a GitCredential", notes = "Creates a new instance of a `GitCredential`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response.", response = Void.class) })
    public Response createGitCredential(@ApiParam(value = "A new `GitCredential` to be created." ,required=true) @NotNull @Valid GitCredential gitCredential,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.createGitCredential(gitCredential,securityContext);
    }
    @DELETE
    @Path("/{gitcredentialId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a GitCredential", notes = "Deletes an existing `GitCredential`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful response.", response = Void.class) })
    public Response deleteGitCredential( @PathParam("gitcredentialId") String gitcredentialId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteGitCredential(gitcredentialId,securityContext);
    }
    @GET
    @Path("/{gitcredentialId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a GitCredential", notes = "Gets the details of a single instance of a `GitCredential`.", response = GitCredential.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns a single `GitCredential`.", response = GitCredential.class) })
    public Response getGitCredential( @PathParam("gitcredentialId") String gitcredentialId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getGitCredential(gitcredentialId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List All gitcredentials", notes = "Gets a list of all `GitCredential` entities.", response = GitCredential.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns an array of `GitCredential` entities.", response = GitCredential.class, responseContainer = "List") })
    public Response getgitcredentials(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getgitcredentials(securityContext);
    }
    @PUT
    @Path("/{gitcredentialId}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a GitCredential", notes = "Updates an existing `GitCredential`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 202, message = "Successful response.", response = Void.class) })
    public Response updateGitCredential( @PathParam("gitcredentialId") String gitcredentialId,@ApiParam(value = "Updated `GitCredential` information." ,required=true) @NotNull @Valid GitCredential gitCredential,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateGitCredential(gitcredentialId,gitCredential,securityContext);
    }
}
