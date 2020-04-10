package com.demosocket.shipyard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class AjaxBody{

    @NotNull
    @Min(value = 0, message = "priceMin should not be less than 0")
    private Integer priceMin;

    @NotNull
    @Min(value = 31000, message = "priceMax should not be less than 31000")
    private Integer priceMax;

    @NotNull
    private Boolean coreDynamics;

    @NotNull
    private Boolean faulconDeLacy;

    @NotNull
    private Boolean gutamaya;

    @NotNull
    private Boolean lakon;

    @NotNull
    private Boolean saudKruger;

    @NotNull
    private Boolean zorgonPeterson;

    @NotNull
    private Boolean large;

    @NotNull
    private Boolean medium;

    @NotNull
    private Boolean small;
}
