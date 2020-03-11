package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.dao.ShipDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ships")
public class ShipController {

    private ShipDao shipDao;

    @Autowired
    public ShipController(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<?> findAll() {
        return shipDao.findAll();
    }

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public List<?> findLarge() {
//        return shipDao.findShips();
//    }

}
