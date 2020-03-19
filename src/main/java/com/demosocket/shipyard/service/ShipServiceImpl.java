package com.demosocket.shipyard.service;

import com.demosocket.shipyard.dao.ShipDao;
import com.demosocket.shipyard.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @Override
    public List<Ship> findShips(Map<String, String> allParams) {
        return shipDao.findShips(allParams);
    }
}
