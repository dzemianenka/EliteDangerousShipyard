package com.demosocket.shipyard.dao;

import java.util.List;

public interface ShipDao {
//    List<?> findAll();
    List<?> findShips(Integer min, Integer max, Boolean coreDynamics, Boolean faulconDeLacy,
                      Boolean gutamaya, Boolean lakon, Boolean saudKruger, Boolean zorgonPeterson,
                      Boolean large, Boolean medium, Boolean small);

}
