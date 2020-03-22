package com.demosocket.shipyard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AjaxBody {

    private Integer priceMin;
    private Integer priceMax;
    private Boolean coreDynamics;
    private Boolean faulconDeLacy;
    private Boolean gutamaya;
    private Boolean lakon;
    private Boolean saudKruger;
    private Boolean zorgonPeterson;
    private Boolean large;
    private Boolean medium;
    private Boolean small;

}
