package com.redhat.openapi.generator.api;

import io.vertx.core.json.JsonObject;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenConfigLoader;
import org.openapitools.codegen.CodegenType;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GeneratorsApiServiceImpl implements GeneratorsApiService {
  @Override
  public Response getgeneratoroptions(String name, SecurityContext securityContext) throws NotFoundException {
    CodegenConfig config = CodegenConfigLoader.forName(name);
    JsonObject retVal = new JsonObject();
    
    return Response.ok(config.cliOptions()).build();
  }

  @Override
  public Response getgenerators(SecurityContext securityContext) throws NotFoundException {
    List<CodegenConfig> generatorList = CodegenConfigLoader.getAll()
        .stream()
        .sorted(this::compareGenerators)
        .collect(Collectors.toList());
    return Response.ok(generatorList).build();
  }

  private int compareGenerators(CodegenConfig g1, CodegenConfig g2) {
    int g1Value = statusScore(g1) + typeScore(g1);
    int g2Value = statusScore(g2) + typeScore(g2);
    return (g2Value - g1Value);
  }

  private int statusScore(CodegenConfig cfg) {
    switch (cfg.getGeneratorMetadata().getStability()) {
      case STABLE:
        return 5;
      case BETA:
        return 4;
      case EXPERIMENTAL:
        return 3;
      default:
        return 0;
    }
  }

  private int typeScore(CodegenConfig cfg) {
    switch (cfg.getTag()) {
      case SERVER:
        return 500;
      case CLIENT:
        return 400;
      case DOCUMENTATION:
        return 300;
      case SCHEMA:
        return 200;
      case CONFIG:
        return 100;
      default:
        return 0;
    }
  }
}
