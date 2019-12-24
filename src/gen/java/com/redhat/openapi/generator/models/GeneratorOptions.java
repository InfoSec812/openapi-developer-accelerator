package com.redhat.openapi.generator.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:42:40.493-05:00[America/Kentucky/Louisville]")
@Entity
public class GeneratorOptions   extends PanacheEntity {
  
  private String option;
  private String description;
  private String defaultValue;
  private String help;
  private String optionType;
  private String enumValues;

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("option")
  public String getOption() {
    return option;
  }
  public void setOption(String option) {
    this.option = option;
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
  @JsonProperty("defaultValue")
  public String getDefaultValue() {
    return defaultValue;
  }
  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("help")
  public String getHelp() {
    return help;
  }
  public void setHelp(String help) {
    this.help = help;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("optionType")
  public String getOptionType() {
    return optionType;
  }
  public void setOptionType(String optionType) {
    this.optionType = optionType;
  }

  /**
   **/
  
  @ApiModelProperty(value = "")
  @JsonProperty("enumValues")
  public String getEnumValues() {
    return enumValues;
  }
  public void setEnumValues(String enumValues) {
    this.enumValues = enumValues;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneratorOptions generatorOptions = (GeneratorOptions) o;
    return Objects.equals(option, generatorOptions.option) &&
        Objects.equals(description, generatorOptions.description) &&
        Objects.equals(defaultValue, generatorOptions.defaultValue) &&
        Objects.equals(help, generatorOptions.help) &&
        Objects.equals(optionType, generatorOptions.optionType) &&
        Objects.equals(enumValues, generatorOptions.enumValues);
  }

  @Override
  public int hashCode() {
    return Objects.hash(option, description, defaultValue, help, optionType, enumValues);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneratorOptions {\n");
    
    sb.append("    option: ").append(toIndentedString(option)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
    sb.append("    help: ").append(toIndentedString(help)).append("\n");
    sb.append("    optionType: ").append(toIndentedString(optionType)).append("\n");
    sb.append("    enumValues: ").append(toIndentedString(enumValues)).append("\n");
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

