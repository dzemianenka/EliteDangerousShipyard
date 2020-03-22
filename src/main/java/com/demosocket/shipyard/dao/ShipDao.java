package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.AjaxBody;
import com.demosocket.shipyard.model.Ship;

import java.util.List;

public interface ShipDao {
    List<Ship> findShips(AjaxBody body);
}
