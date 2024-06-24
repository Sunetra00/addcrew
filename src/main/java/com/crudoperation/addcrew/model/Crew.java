package com.crudoperation.addcrew.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "crewid",
        "firstName",
        "lastName",
        "nickname",
        "city",
        "rank"
})
public class Crew {
    @JsonProperty
    private String crewid;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String nickname;
    @JsonProperty
    private String city;
    private String rank;
}