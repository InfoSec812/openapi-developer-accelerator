package com.redhat.openapi.generator.service;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.RoutingContext;
import org.openapitools.codegen.CodegenConfig;
import org.openapitools.codegen.CodegenConfigLoader;

import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.Values.APPLICATION_JSON;

public class MainVerticle extends AbstractVerticle {

    public void start(Promise<Void> startPromise) throws Exception {
        Router router = Router.router(vertx);

        router.get("/generator").produces(APPLICATION_JSON).handler(this::listAvailableCodeGenerators);
        router.get("/generator/:name").produces(APPLICATION_JSON).handler(this::listGeneratorOptions);


        vertx.createHttpServer().requestHandler(router).listen(8080);

        startPromise.complete();
    }

    private void listGeneratorOptions(RoutingContext ctx) {
        CodegenConfig config = CodegenConfigLoader.forName(ctx.pathParam("name"));
        JsonArray configOptions = new JsonArray();
        config.cliOptions().stream()
                .sorted((opt1, opt2) -> opt1.getOpt().compareTo(opt2.getOpt()))
                .forEach(cliOpt -> {
                    JsonObject configOption = new JsonObject();
                    configOption.put("option", cliOpt.getOpt());
                    configOption.put("description", cliOpt.getDescription());
                    configOption.put("defaultValue", cliOpt.getDefault());
                    configOption.put("help", cliOpt.getOptionHelp());
                    configOption.put("optionType", cliOpt.getType());
                    configOption.put("enumValues", cliOpt.getEnum());
                    configOptions.add(configOption);
                });
        ctx.response().setStatusMessage("OK").setStatusCode(200).end(configOptions.encodePrettily());
    }

    private void listAvailableCodeGenerators(RoutingContext ctx) {
        JsonArray genList = new JsonArray();
        List<CodegenConfig> generatorList = CodegenConfigLoader.getAll();

        generatorList.stream()
                .sorted((opt1, opt2) -> opt1.getName().compareTo(opt2.getName()))
                .forEach(generator -> {
            JsonObject genItem = new JsonObject();
            genItem.put("name", generator.getName());
            genItem.put("description", generator.getHelp());
            genList.add(genItem);
        });
        ctx.response().setStatusCode(200).setStatusMessage("OK").end(genList.toString());
    }
}
