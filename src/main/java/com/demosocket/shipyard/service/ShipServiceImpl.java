package com.demosocket.shipyard.service;

import com.demosocket.shipyard.dao.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipDao shipDao;

    @Autowired
    public ShipServiceImpl(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @Override
    public List<?> getAll() {
        return shipDao.findAll();
    }

//    @Override
//    public List<?> findShips() {
//        return shipDao.findShips();
//    }
}
