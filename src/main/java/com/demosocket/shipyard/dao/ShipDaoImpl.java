package com.demosocket.shipyard.dao;

import com.demosocket.shipyard.model.AjaxBody;
import com.demosocket.shipyard.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
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


//        Cost Predicate
        Predicate predicateC = criteriaBuilder.between(shipRoot.get("cost"), body.getPriceMin(), body.getPriceMax());

        Map<String, Boolean> manufacturerMap = new HashMap<>();
        manufacturerMap.put("%Core Dynamics%", body.getCoreDynamics());
        manufacturerMap.put("%Faulcon DeLacy%", body.getFaulconDeLacy());
        manufacturerMap.put("%Gutamaya%", body.getGutamaya());
        manufacturerMap.put("%Lakon%", body.getLakon());
        manufacturerMap.put("%Saud Kruger%", body.getSaudKruger());
        manufacturerMap.put("%Zorgon Peterson%", body.getZorgonPeterson());

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
        costMap.put("%Large%", body.getLarge());
        costMap.put("%Medium%", body.getMedium());
        costMap.put("%Small%", body.getSmall());

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

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
