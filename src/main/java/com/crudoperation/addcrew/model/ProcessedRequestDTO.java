package com.crudoperation.addcrew.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operationType",
        "id",
        "crew"
})
@Data
public class ProcessedRequestDTO {

    @JsonProperty("operationType")
    private String operationType;
    @JsonProperty("id")
    private String crewid;
    @JsonProperty("crew")
    private Crew crewDTO;

}
