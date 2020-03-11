package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
//@Transactional
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
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Ship> criteriaQuery = criteriaBuilder.createQuery(Ship.class);
        Root<Ship> ships = criteriaQuery.from(Ship.class);
        criteriaQuery.select(ships).where(criteriaBuilder.between(ships.get("cost"),31000,1000000));
        Query<Ship> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
