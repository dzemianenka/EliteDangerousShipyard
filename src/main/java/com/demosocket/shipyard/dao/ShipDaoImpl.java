package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipDaoImpl implements ShipDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ShipDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<?> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM " + Ship.class.getName()).list();
    }

    @Override
    public List<?> findLarge() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.size LIKE '%Large%'").list();
    }

    @Override
    public List<?> findMedium() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.size LIKE '%Medium%'").list();
    }

    @Override
    public List<?> findSmall() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.size LIKE '%Small%'").list();
    }

    @Override
    public List<?> findCoreDynamics() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Core Dynamics%'").list();
    }

    @Override
    public List<?> findFaulconDeLacy() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Faulcon DeLacy%'").list();
    }

    @Override
    public List<?> findGutamaya() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Gutamaya%'").list();
    }

    @Override
    public List<?> findLakon() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Lakon%'").list();
    }

    @Override
    public List<?> findSaudKruger() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Saud Kruger%'").list();
    }

    @Override
    public List<?> findZorgonPeterson() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Ship S WHERE S.manufacturer LIKE '%Zorgon Peterson%'").list();
    }
}
