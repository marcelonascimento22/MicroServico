package br.com.dio.storefont.controller.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductSaveResponse(
    @JsonProperty("id")
    UUID id,
    @JsonProperty("name")
    String name,
    @JsonProperty("active")
    Boolean active
) {

}
