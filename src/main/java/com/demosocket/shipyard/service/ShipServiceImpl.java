package com.demosocket.shipyard.service;

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
    public List<?> getAll() {
        return shipDao.findAll();
    }

    @Override
    public List<?> findLarge(){
        return shipDao.findLarge();
    }

    @Override
    public List<?> findMedium() {
        return shipDao.findMedium();
    }

    @Override
    public List<?> findSmall() {
        return shipDao.findSmall();
    }

    @Override
    public List<?> findCoreDynamics() {
        return shipDao.findCoreDynamics();
    }

    @Override
    public List<?> findFaulconDeLacy() {
        return shipDao.findFaulconDeLacy();
    }

    @Override
    public List<?> findGutamaya() {
        return shipDao.findGutamaya();
    }

    @Override
    public List<?> findLakon() {
        return shipDao.findLakon();
    }

    @Override
    public List<?> findSaudKruger() {
        return shipDao.findSaudKruger();
    }

    @Override
    public List<?> findZorgonPeterson() {
        return shipDao.findZorgonPeterson();
    }
}
