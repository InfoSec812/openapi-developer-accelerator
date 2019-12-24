package com.redhat.openapi.generator.models;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import io.swagger.annotations.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2019-12-23T16:42:40.493-05:00[America/Kentucky/Louisville]")
@Entity
public class GitCredential   extends PanacheEntity {
  

  /**
   * The type of credential this is
   */
  public enum TypeEnum {
    SSHKEY("sshKey"),

        USERNAMEPASSWORD("usernamePassword"),

        TOKEN("token");
    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TypeEnum type;
  private String key;
  private String username;
  private String password;
  private String token;

  /**
   * The type of credential this is
   **/
  
  @ApiModelProperty(required = true, value = "The type of credential this is")
  @JsonProperty("type")
  @NotNull
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /**
   * When type is &#39;sshKey&#39;, this is the private key for SSH authentication
   **/
  
  @ApiModelProperty(value = "When type is 'sshKey', this is the private key for SSH authentication")
  @JsonProperty("key")
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * When type is &#39;usernamePassword&#39;, this is the username to use for Git authentication
   **/
  
  @ApiModelProperty(value = "When type is 'usernamePassword', this is the username to use for Git authentication")
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * When type is &#x60;usernamePassword&#x60;, this is the password for git authentication
   **/
  
  @ApiModelProperty(value = "When type is `usernamePassword`, this is the password for git authentication")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * When type is &#39;token&#39;, this is the token to use for Git authentication
   **/
  
  @ApiModelProperty(value = "When type is 'token', this is the token to use for Git authentication")
  @JsonProperty("token")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GitCredential gitCredential = (GitCredential) o;
    return Objects.equals(type, gitCredential.type) &&
        Objects.equals(key, gitCredential.key) &&
        Objects.equals(username, gitCredential.username) &&
        Objects.equals(password, gitCredential.password) &&
        Objects.equals(token, gitCredential.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, key, username, password, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GitCredential {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

