package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public List<?> findShips() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        List<?> ourShips = em.createQuery("SELECT Ship " +
                "FROM Ship " +
                "WHERE (Ship.cost < ?1 AND Ship.cost < ?2) AND " +
                "(Ship.manufacturer LIKE ?3 OR " +
                "Ship.manufacturer LIKE ?4 OR " +
                "Ship.manufacturer LIKE ?5 OR " +
                "Ship.manufacturer LIKE ?6 OR " +
                "Ship.manufacturer LIKE ?7 OR " +
                "Ship.manufacturer LIKE ?8) AND " +
                "(Ship.size LIKE ?9 OR " +
                "Ship.size LIKE ?10 OR " +
                "Ship.size LIKE ?11)")
                .setParameter(1, 31000)
                .setParameter(2, 208968450)
                .setParameter(3, "Core Dynamics")
                .setParameter(4,"Faulcon DeLacy")
                .setParameter(5,"Gutamaya")
                .setParameter(6, "Lakon")
                .setParameter(7, "Saud Kruger")
                .setParameter(8, "Zorgon Peterson")
                .setParameter(9, "Large")
                .setParameter(10, "Medium")
                .setParameter(11, "Small").getResultList();
        return ourShips;
    }
}
