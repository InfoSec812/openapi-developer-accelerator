package com.redhat.openapi.generator.api;

import io.vertx.core.json.JsonObject;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenConfigLoader;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@ApplicationScoped
public class GeneratorsApiServiceImpl implements GeneratorsApiService {
  @Override
  public Response getgeneratoroptions(String name, SecurityContext securityContext) throws NotFoundException {
    CodegenConfig config = CodegenConfigLoader.forName(name);
    JsonObject retVal = new JsonObject();
    
    return Response.ok(config).build();
  }

  @Override
  public Response getgenerators(SecurityContext securityContext) throws NotFoundException {
    List<CodegenConfig> generatorList = CodegenConfigLoader.getAll();
    return Response.ok(generatorList).build();
  }
}
