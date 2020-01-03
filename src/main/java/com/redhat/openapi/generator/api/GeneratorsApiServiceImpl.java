package com.redhat.openapi.generator.api;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenConfigLoader;
import org.openapitools.codegen.CodegenType;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GeneratorsApiServiceImpl implements GeneratorsApiService {

  private final Jsonb jsonb = JsonbBuilder.newBuilder().build();

  @Override
  public Response getgeneratoroptions(String name, SecurityContext securityContext) throws NotFoundException {
    CodegenConfig config = CodegenConfigLoader.forName(name);
    List<JsonObject> opts = config.cliOptions().stream()
        .map(opt -> new JsonObject(jsonb.toJson(opt)))
        .map(this::identifyAdvancedOptions)
        .collect(Collectors.toList());
    JsonArray retVal = new JsonArray(opts);

    return Response.ok(retVal.encodePrettily()).build();
  }

  private JsonObject identifyAdvancedOptions(JsonObject opt) {
    opt.put("advanced", true);
    if (opt.containsKey("default")) {
      if (opt.getString("default").toLowerCase().contains("openapi")) {
        opt.put("advanced", false);
      }
    }
    return opt;
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
    int stringCompare = g2.getName().toLowerCase().compareTo(g1.getName().toLowerCase());
    return (g2Value - g1Value) - stringCompare;
  }

  private int statusScore(CodegenConfig cfg) {
    switch (cfg.getGeneratorMetadata().getStability()) {
      case STABLE:
        return 300;
      case BETA:
        return 200;
      case EXPERIMENTAL:
        return 100;
      default:
        return 0;
    }
  }

  private int typeScore(CodegenConfig cfg) {
    switch (cfg.getTag()) {
      case SERVER:
        return 5000;
      case CLIENT:
        return 4000;
      case DOCUMENTATION:
        return 3000;
      case SCHEMA:
        return 2000;
      case CONFIG:
        return 1000;
      default:
        return 0;
    }
  }
}
