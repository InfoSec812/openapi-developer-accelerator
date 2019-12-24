package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Implementation;
import io.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/implementations")


@io.swagger.annotations.Api(description = "the implementations API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public class ImplementationsApi  {

    @Inject ImplementationsApiService service;

    @POST
    
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Create a Implementation", notes = "Creates a new instance of a `Implementation`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "Successful response.", response = Void.class) })
    public Response createImplementation(@ApiParam(value = "A new `Implementation` to be created." ,required=true) @NotNull @Valid Implementation implementation,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.createImplementation(implementation,securityContext);
    }
    @DELETE
    @Path("/{implementationId}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a Implementation", notes = "Deletes an existing `Implementation`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful response.", response = Void.class) })
    public Response deleteImplementation( @PathParam("implementationId") String implementationId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.deleteImplementation(implementationId,securityContext);
    }
    @GET
    @Path("/{implementationId}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a Implementation", notes = "Gets the details of a single instance of a `Implementation`.", response = Implementation.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns a single `Implementation`.", response = Implementation.class) })
    public Response getImplementation( @PathParam("implementationId") String implementationId,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getImplementation(implementationId,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List All implementations", notes = "Gets a list of all `Implementation` entities.", response = Implementation.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns an array of `Implementation` entities.", response = Implementation.class, responseContainer = "List") })
    public Response getimplementations(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getimplementations(securityContext);
    }
    @PUT
    @Path("/{implementationId}")
    @Consumes({ "application/json" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a Implementation", notes = "Updates an existing `Implementation`.", response = Void.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 202, message = "Successful response.", response = Void.class) })
    public Response updateImplementation( @PathParam("implementationId") String implementationId,@ApiParam(value = "Updated `Implementation` information." ,required=true) @NotNull @Valid Implementation implementation,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.updateImplementation(implementationId,implementation,securityContext);
    }
}
