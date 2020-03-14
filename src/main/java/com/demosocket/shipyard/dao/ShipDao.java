package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;

import java.util.List;

public interface ShipDao {
    List<Ship> findShips(Integer min, Integer max, Boolean coreDynamics, Boolean faulconDeLacy,
                         Boolean gutamaya, Boolean lakon, Boolean saudKruger, Boolean zorgonPeterson,
                         Boolean large, Boolean medium, Boolean small);

}
