package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.Ship;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShipDaoImpl implements ShipDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ShipDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    public List<?> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("FROM " + Ship.class.getName()).list();
//    }

    @Override
    public List<Ship> findShips(Integer min, Integer max, Boolean coreDynamics, Boolean faulconDeLacy,
                             Boolean gutamaya, Boolean lakon, Boolean saudKruger, Boolean zorgonPeterson,
                             Boolean large, Boolean medium, Boolean small) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Ship> criteriaQuery = criteriaBuilder.createQuery(Ship.class);
        Root<Ship> shipRoot = criteriaQuery.from(Ship.class);

//        Cost Predicate
        Predicate predicateC = criteriaBuilder.between(shipRoot.get("cost"), min, max);

        Map<String, Boolean> manufacturerMap = new HashMap<>();
        manufacturerMap.put("%Core Dynamics%", coreDynamics);
        manufacturerMap.put("%Faulcon DeLacy%", faulconDeLacy);
        manufacturerMap.put("%Gutamaya%", gutamaya);
        manufacturerMap.put("%Lakon%", lakon);
        manufacturerMap.put("%Saud Kruger%", saudKruger);
        manufacturerMap.put("%Zorgon Peterson%", zorgonPeterson);

        List<Predicate> manufacturerPredicates = new ArrayList<>();
        if (manufacturerMap.containsValue(true)) {
            for (Map.Entry<String, Boolean> entry : manufacturerMap.entrySet()) {
                if (entry.getValue()) {
                    manufacturerPredicates.add(criteriaBuilder.like(shipRoot.get("manufacturer"), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<String, Boolean> entry : manufacturerMap.entrySet()) {
                manufacturerPredicates.add(criteriaBuilder.like(shipRoot.get("manufacturer"), entry.getKey()));
            }
        }

//        Manufacturer Predicate
        Predicate predicateM = criteriaBuilder.or(manufacturerPredicates.toArray(new Predicate[0]));

        Map<String, Boolean> costMap = new HashMap<>();
        costMap.put("%Large%", large);
        costMap.put("%Medium%", medium);
        costMap.put("%Small%", small);

        List<Predicate> sizePredicates = new ArrayList<>();
        if (costMap.containsValue(true)) {
            for (Map.Entry<String, Boolean> entry : costMap.entrySet()) {
                if (entry.getValue()) {
                    sizePredicates.add(criteriaBuilder.like(shipRoot.get("size"), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<String, Boolean> entry : costMap.entrySet()) {
                sizePredicates.add(criteriaBuilder.like(shipRoot.get("size"), entry.getKey()));
            }
        }

//        Size Predicate
        Predicate predicateS = criteriaBuilder.or(sizePredicates.toArray(new Predicate[0]));

//        Result Predicate
        Predicate resultPredicate = criteriaBuilder.and(predicateC, predicateM, predicateS);

        criteriaQuery.select(shipRoot).where(resultPredicate);

        return session.createQuery(criteriaQuery).getResultList();
    }
}
