package com.demosocket.shipyard.dao;

import java.util.List;

public interface ShipDao {
    List<?> findAll();
    List<?> findLarge();
    List<?> findMedium();
    List<?> findSmall();
    List<?> findCoreDynamics();
    List<?> findFaulconDeLacy();
    List<?> findGutamaya();
    List<?> findLakon();
    List<?> findSaudKruger();
    List<?> findZorgonPeterson();
}
