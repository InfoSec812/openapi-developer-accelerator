package com.redhat.openapi.generator.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:42:40.493-05:00[America/Kentucky/Louisville]")
@Entity
public class Project   extends PanacheEntity {
  
  private Long id;
  private String name;
  private String description;
  private String specification;
  private OffsetDateTime created;
  private String owner;

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
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("specification")
  public String getSpecification() {
    return specification;
  }
  public void setSpecification(String specification) {
    this.specification = specification;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }
  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("owner")
  public String getOwner() {
    return owner;
  }
  public void setOwner(String owner) {
    this.owner = owner;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Project project = (Project) o;
    return Objects.equals(id, project.id) &&
        Objects.equals(name, project.name) &&
        Objects.equals(description, project.description) &&
        Objects.equals(specification, project.specification) &&
        Objects.equals(created, project.created) &&
        Objects.equals(owner, project.owner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, specification, created, owner);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    specification: ").append(toIndentedString(specification)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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

