package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShipDaoImpl implements ShipDao {

    private EntityManager entityManager;

    @Autowired
    public ShipDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Ship> findShips(AjaxBody body) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ship> criteriaQuery = criteriaBuilder.createQuery(Ship.class);
        Root<Ship> shipRoot = criteriaQuery.from(Ship.class);

        shipRoot.fetch(Ship_.manufacturer, JoinType.LEFT);
        shipRoot.fetch(Ship_.size, JoinType.LEFT);
        criteriaQuery.select(shipRoot).distinct(true);

//        Cost Predicate
        Predicate predicateC = criteriaBuilder.between(shipRoot.get(Ship_.cost), body.getPriceMin(), body.getPriceMax());

        Map<Integer, Boolean> manufacturerMap = new HashMap<>();
        manufacturerMap.put(1, body.getCoreDynamics());
        manufacturerMap.put(2, body.getFaulconDeLacy());
        manufacturerMap.put(3, body.getGutamaya());
        manufacturerMap.put(4, body.getLakon());
        manufacturerMap.put(5, body.getSaudKruger());
        manufacturerMap.put(6, body.getZorgonPeterson());

        List<Predicate> manufacturerPredicates = new ArrayList<>();
        if (manufacturerMap.containsValue(true)) {
            for (Map.Entry<Integer, Boolean> entry : manufacturerMap.entrySet()) {
                if (entry.getValue()) {
                    manufacturerPredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.manufacturer), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<Integer, Boolean> entry : manufacturerMap.entrySet()) {
                manufacturerPredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.manufacturer), entry.getKey()));
            }
        }

//        Manufacturer Predicate
        Predicate predicateM = criteriaBuilder.or(manufacturerPredicates.toArray(new Predicate[0]));

        Map<Integer, Boolean> costMap = new HashMap<>();
        costMap.put(1, body.getLarge());
        costMap.put(2, body.getMedium());
        costMap.put(3, body.getSmall());

        List<Predicate> sizePredicates = new ArrayList<>();
        if (costMap.containsValue(true)) {
            for (Map.Entry<Integer, Boolean> entry : costMap.entrySet()) {
                if (entry.getValue()) {
                    sizePredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.size), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<Integer, Boolean> entry : costMap.entrySet()) {
                sizePredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.size), entry.getKey()));
            }
        }

//        Size Predicate
        Predicate predicateS = criteriaBuilder.or(sizePredicates.toArray(new Predicate[0]));

//        Result Predicate
        Predicate resultPredicate = criteriaBuilder.and(predicateC, predicateM, predicateS);

//        order by
        criteriaQuery.orderBy(criteriaBuilder.asc(shipRoot.get(Ship_.shipModel)));

        criteriaQuery.select(shipRoot).where(resultPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
