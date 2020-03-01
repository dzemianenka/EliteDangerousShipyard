package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipDaoImpl implements ShipDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ShipDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ship> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + Ship.class.getName()).list();
    }
}
