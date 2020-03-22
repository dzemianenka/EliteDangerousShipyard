package com.demosocket.shipyard.service;

import com.demosocket.shipyard.model.AjaxBody;
import com.demosocket.shipyard.model.Ship;

import java.util.List;

public interface ShipService {
    List<Ship> findShips(AjaxBody body);
}
