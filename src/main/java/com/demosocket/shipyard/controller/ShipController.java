package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.dao.ShipDao;
import com.demosocket.shipyard.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Ship> findShips(@RequestParam(value = "min") Integer min,
                                @RequestParam(value = "max") Integer max,
                                @RequestParam(value = "coreDynamics") Boolean coreDynamics,
                                @RequestParam(value = "faulconDeLacy") Boolean faulconDeLacy,
                                @RequestParam(value = "gutamaya") Boolean gutamaya,
                                @RequestParam(value = "lakon") Boolean lakon,
                                @RequestParam(value = "saudKruger") Boolean saudKruger,
                                @RequestParam(value = "zorgonPeterson") Boolean zorgonPeterson,
                                @RequestParam(value = "large") Boolean large,
                                @RequestParam(value = "medium") Boolean medium,
                                @RequestParam(value = "small") Boolean small) {

        return shipDao.findShips(min, max, coreDynamics, faulconDeLacy, gutamaya,
                lakon, saudKruger, zorgonPeterson, large, medium, small);
    }

}
