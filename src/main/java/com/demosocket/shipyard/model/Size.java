package com.demosocket.shipyard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Size {

    LARGE("Large"),
    MEDIUM("Medium"),
    SMALL("Small");

    @Getter
    private final String title;
}
