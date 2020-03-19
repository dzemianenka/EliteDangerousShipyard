package com.demosocket.shipyard.service;

import com.demosocket.shipyard.model.Ship;

import java.util.List;
import java.util.Map;

public interface ShipService {
    List<Ship> findShips(Map<String, String> allParams);
}
