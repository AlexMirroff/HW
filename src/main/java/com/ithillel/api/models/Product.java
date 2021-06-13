package com.ithillel.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private Long id;
    private String name;
    private Category category;
    private String manufacturer;
}