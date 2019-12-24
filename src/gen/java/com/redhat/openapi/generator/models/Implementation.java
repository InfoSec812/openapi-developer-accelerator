package com.redhat.openapi.generator.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.vertx.core.json.JsonObject;

import javax.persistence.Entity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:42:40.493-05:00[America/Kentucky/Louisville]")
@Entity
public class Implementation   extends PanacheEntity {
  
  private Long id;
  private Long projectId;
  private String name;
  private String implementation;
  private String gitUrl;
  private Boolean customizeTemplates;
  private String _configuration = "{}";

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("projectId")
  public Long getProjectId() {
    return projectId;
  }
  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("implementation")
  public String getImplementation() {
    return implementation;
  }
  public void setImplementation(String implementation) {
    this.implementation = implementation;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("gitUrl")
  public String getGitUrl() {
    return gitUrl;
  }
  public void setGitUrl(String gitUrl) {
    this.gitUrl = gitUrl;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("customizeTemplates")
  public Boolean isCustomizeTemplates() {
    return customizeTemplates;
  }
  public void setCustomizeTemplates(Boolean customizeTemplates) {
    this.customizeTemplates = customizeTemplates;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("configuration")
  public JsonObject getConfiguration() {
    return new JsonObject(_configuration);
  }
  public void setConfiguration(JsonObject _configuration) {
    this._configuration = _configuration.encodePrettily();
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Implementation implementation = (Implementation) o;
    return Objects.equals(id, implementation.id) &&
        Objects.equals(projectId, implementation.projectId) &&
        Objects.equals(name, implementation.name) &&
        Objects.equals(implementation, implementation.implementation) &&
        Objects.equals(gitUrl, implementation.gitUrl) &&
        Objects.equals(customizeTemplates, implementation.customizeTemplates) &&
        Objects.equals(_configuration, implementation._configuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, projectId, name, implementation, gitUrl, customizeTemplates, _configuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Implementation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    implementation: ").append(toIndentedString(implementation)).append("\n");
    sb.append("    gitUrl: ").append(toIndentedString(gitUrl)).append("\n");
    sb.append("    customizeTemplates: ").append(toIndentedString(customizeTemplates)).append("\n");
    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

