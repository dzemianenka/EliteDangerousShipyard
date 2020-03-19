package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;

import java.util.List;
import java.util.Map;

public interface ShipDao {
    List<Ship> findShips(Map<String, String> allParams);
}
