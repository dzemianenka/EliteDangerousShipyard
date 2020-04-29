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
    private final Integer priceMin;

    @NotNull
    @Min(value = 31000, message = "priceMax should not be less than 31000")
    private final Integer priceMax;

    @NotNull
    private final Boolean coreDynamics;

    @NotNull
    private final Boolean faulconDeLacy;

    @NotNull
    private final Boolean gutamaya;

    @NotNull
    private final Boolean lakon;

    @NotNull
    private final Boolean saudKruger;

    @NotNull
    private final Boolean zorgonPeterson;

    @NotNull
    private final Boolean large;

    @NotNull
    private final Boolean medium;

    @NotNull
    private final Boolean small;
}
