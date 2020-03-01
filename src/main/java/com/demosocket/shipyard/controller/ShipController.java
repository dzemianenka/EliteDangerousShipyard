package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.model.Ship;
import com.demosocket.shipyard.dao.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipController {

    private ShipDao shipDao;

    @Autowired
    public ShipController(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @RequestMapping(value = "/ships", method = RequestMethod.GET)
    public List<Ship> findAll() {
        return shipDao.findAll();
    }
}
