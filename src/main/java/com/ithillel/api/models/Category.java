package com.ithillel.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {

    private Long id;
    private String name;
    private String location;
}