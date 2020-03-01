package com.demosocket.shipyard.service;

import com.demosocket.shipyard.model.Ship;
import com.demosocket.shipyard.dao.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipServiceImpl implements ShipService {

    private ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @Override
    public List<Ship> getAll() {
        return shipDao.findAll();
    }
}
