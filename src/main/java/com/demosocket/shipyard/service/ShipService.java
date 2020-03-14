package com.demosocket.shipyard.service;

import java.util.List;

public interface ShipService {
//    List<?> getAll();
    List<?> findShips(Integer min, Integer max, Boolean coreDynamics, Boolean faulconDeLacy,
                      Boolean gutamaya, Boolean lakon, Boolean saudKruger, Boolean zorgonPeterson,
                      Boolean large, Boolean medium, Boolean small);
}
