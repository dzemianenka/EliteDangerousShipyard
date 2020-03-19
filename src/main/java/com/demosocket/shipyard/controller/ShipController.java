package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.dao.ShipDao;
import com.demosocket.shipyard.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ships")
public class ShipController {

    private ShipDao shipDao;

    @Autowired
    public ShipController(ShipDao shipDao) {
        this.shipDao = shipDao;
    }

    @PostMapping("/search")
    @ResponseBody
    public List<Ship> findShips(@RequestParam Map<String, String> allParams) {
        return shipDao.findShips(allParams);
    }

}
