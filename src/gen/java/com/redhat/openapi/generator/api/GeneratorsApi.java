package com.redhat.openapi.generator.api;

import com.redhat.openapi.generator.models.Generator;
import com.redhat.openapi.generator.models.GeneratorOptions;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/generators")


@io.swagger.annotations.Api(description = "the generators API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:41:52.795-05:00[America/Kentucky/Louisville]")
public class GeneratorsApi  {

    @Inject GeneratorsApiService service;

    @GET
    @Path("/{name}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List All generatoroptions", notes = "Gets a list of all `GeneratorOptions` entities.", response = GeneratorOptions.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns an array of `GeneratorOptions` entities.", response = GeneratorOptions.class, responseContainer = "List") })
    public Response getgeneratoroptions( @PathParam("name") String name,@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getgeneratoroptions(name,securityContext);
    }
    @GET
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List All generators", notes = "Gets a list of all `Generator` entities.", response = Generator.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response - returns an array of `Generator` entities.", response = Generator.class, responseContainer = "List") })
    public Response getgenerators(@Context SecurityContext securityContext)
    throws NotFoundException {
        return service.getgenerators(securityContext);
    }
}
