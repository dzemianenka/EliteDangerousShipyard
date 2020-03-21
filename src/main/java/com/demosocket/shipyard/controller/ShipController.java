package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.model.Ship;
import com.demosocket.shipyard.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ships")
public class ShipController {

    private ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping("/search")
    @ResponseBody
    public List<Ship> findShips(@RequestParam Map<String, String> allParams) {

        return shipService.findShips(allParams);
    }

}
