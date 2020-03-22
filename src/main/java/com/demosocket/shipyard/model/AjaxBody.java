package com.demosocket.shipyard.model;

import lombok.Getter;

@Getter
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

    public AjaxBody(Integer priceMin, Integer priceMax, Boolean coreDynamics, Boolean faulconDeLacy,
                    Boolean gutamaya, Boolean lakon, Boolean saudKruger, Boolean zorgonPeterson,
                    Boolean large, Boolean medium, Boolean small) {

        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.coreDynamics = coreDynamics;
        this.faulconDeLacy = faulconDeLacy;
        this.gutamaya = gutamaya;
        this.lakon = lakon;
        this.saudKruger = saudKruger;
        this.zorgonPeterson = zorgonPeterson;
        this.large = large;
        this.medium = medium;
        this.small = small;
    }

}
