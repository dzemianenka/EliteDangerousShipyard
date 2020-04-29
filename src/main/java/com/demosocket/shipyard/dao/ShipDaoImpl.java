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

    private final EntityManager entityManager;

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
        Predicate predicateC = criteriaBuilder.between(shipRoot.get(Ship_.cost),body.getPriceMin(), body.getPriceMax());

        Map<Manufacturer, Boolean> manufacturerMap = new HashMap<>();
        manufacturerMap.put(Manufacturer.CORE_DYNAMICS, body.getCoreDynamics());
        manufacturerMap.put(Manufacturer.FAULCON_DELACY, body.getFaulconDeLacy());
        manufacturerMap.put(Manufacturer.GUTAMAYA, body.getGutamaya());
        manufacturerMap.put(Manufacturer.LAKON, body.getLakon());
        manufacturerMap.put(Manufacturer.SAUD_KRUGER, body.getSaudKruger());
        manufacturerMap.put(Manufacturer.ZORGON_PETERSON, body.getZorgonPeterson());

        List<Predicate> manufacturerPredicates = new ArrayList<>();
        if (manufacturerMap.containsValue(true)) {
            for (Map.Entry<Manufacturer, Boolean> entry : manufacturerMap.entrySet()) {
                if (entry.getValue()) {
                    manufacturerPredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.manufacturer), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<Manufacturer, Boolean> entry : manufacturerMap.entrySet()) {
                manufacturerPredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.manufacturer), entry.getKey()));
            }
        }

//        Manufacturer Predicate
        Predicate predicateM = criteriaBuilder.or(manufacturerPredicates.toArray(new Predicate[0]));

        Map<Size, Boolean> costMap = new HashMap<>();
        costMap.put(Size.LARGE, body.getLarge());
        costMap.put(Size.MEDIUM, body.getMedium());
        costMap.put(Size.SMALL, body.getSmall());

        List<Predicate> sizePredicates = new ArrayList<>();
        if (costMap.containsValue(true)) {
            for (Map.Entry<Size, Boolean> entry : costMap.entrySet()) {
                if (entry.getValue()) {
                    sizePredicates.add(criteriaBuilder.equal(shipRoot.get(Ship_.size), entry.getKey()));
                }
            }
        } else {
            for (Map.Entry<Size, Boolean> entry : costMap.entrySet()) {
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