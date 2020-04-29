package com.demosocket.shipyard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Manufacturer {

    CORE_DYNAMICS("Core Dynamics"),
    FAULCON_DELACY("Faulcon DeLacy"),
    GUTAMAYA("Gutamaya"),
    LAKON("Lakon"),
    SAUD_KRUGER("Saud Kruger"),
    ZORGON_PETERSON("Zorgon Peterson");

    @Getter
    private final String title;
}
