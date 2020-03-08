package com.demosocket.shipyard.service;

import java.util.List;

public interface ShipService {
    List<?> getAll();
    List<?> findLarge() throws NoSuchFieldException;
    List<?> findMedium();
    List<?> findSmall();
    List<?> findCoreDynamics();
    List<?> findFaulconDeLacy();
    List<?> findGutamaya();
    List<?> findLakon();
    List<?> findSaudKruger();
    List<?> findZorgonPeterson();
}
