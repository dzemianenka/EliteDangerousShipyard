package com.demosocket.shipyard.controller;

import com.demosocket.shipyard.model.AjaxBody;
import com.demosocket.shipyard.model.Ship;
import com.demosocket.shipyard.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @PostMapping("/search")
    public List<Ship> getSearchAjax(@RequestBody AjaxBody body) {

        return shipService.findShips(body);
    }

}
