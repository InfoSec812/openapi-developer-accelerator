package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Project;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/projects")


@io.swagger.annotations.Api(description = "the projects API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public class ProjectsApi  {

    @Inject ProjectsApiService service;

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Create a Project", notes = "Creates a new instance of a `Project`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response.", response = Void.class) })
    public Response createProject(@ApiParam(value = "A new `Project` to be created." ,required=true) @NotNull @Valid Project project,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.createProject(project,securityContext);
    }
    @DELETE
    @Path("/{projectId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a Project", notes = "Deletes an existing `Project`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful response.", response = Void.class) })
    public Response deleteProject( @PathParam("projectId") String projectId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteProject(projectId,securityContext);
    }
    @GET
    @Path("/{projectId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a Project", notes = "Gets the details of a single instance of a `Project`.", response = Project.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns a single `Project`.", response = Project.class) })
    public Response getProject( @PathParam("projectId") String projectId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getProject(projectId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List All projects", notes = "Gets a list of all `Project` entities.", response = Project.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns an array of `Project` entities.", response = Project.class, responseContainer = "List") })
    public Response getprojects(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getprojects(securityContext);
    }
    @PUT
    @Path("/{projectId}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a Project", notes = "Updates an existing `Project`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 202, message = "Successful response.", response = Void.class) })
    public Response updateProject( @PathParam("projectId") String projectId,@ApiParam(value = "Updated `Project` information." ,required=true) @NotNull @Valid Project project,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateProject(projectId,project,securityContext);
    }
}
