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

    @RequestMapping(value = "/large", method = RequestMethod.GET)
    public List<?> findLarge() {
        return shipDao.findLarge();
    }

    @RequestMapping(value = "/medium", method = RequestMethod.GET)
    public List<?> findMedium() {
        return shipDao.findMedium();
    }

    @RequestMapping(value = "/small", method = RequestMethod.GET)
    public List<?> findSmall() {
        return shipDao.findSmall();
    }

    @RequestMapping(value = "/coredymanics", method = RequestMethod.GET)
    public List<?> findCoreDynamics() {
        return shipDao.findCoreDynamics();
    }

    @RequestMapping(value = "/faulcondelacy", method = RequestMethod.GET)
    public List<?> findFaulconDeLacy() {
        return shipDao.findFaulconDeLacy();
    }

    @RequestMapping(value = "/gutamaya", method = RequestMethod.GET)
    public List<?> findGutamaya() {
        return shipDao.findGutamaya();
    }

    @RequestMapping(value = "/lakon", method = RequestMethod.GET)
    public List<?> findLakon() {
        return shipDao.findLakon();
    }

    @RequestMapping(value = "/saudkruger", method = RequestMethod.GET)
    public List<?> findSaudKruger() {
        return shipDao.findSaudKruger();
    }

    @RequestMapping(value = "/zorgonpeterson", method = RequestMethod.GET)
    public List<?> findZorgonPeterson() {
        return shipDao.findZorgonPeterson();
    }
}
