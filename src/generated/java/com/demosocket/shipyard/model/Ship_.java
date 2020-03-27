package com.demosocket.shipyard.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ship.class)
public abstract class Ship_ {

	public static volatile SingularAttribute<Ship, Integer> cost;
	public static volatile SingularAttribute<Ship, Size> size;
	public static volatile SingularAttribute<Ship, Integer> id;
	public static volatile SingularAttribute<Ship, String> shipModel;
	public static volatile SingularAttribute<Ship, Manufacturer> manufacturer;

	public static final String COST = "cost";
	public static final String SIZE = "size";
	public static final String ID = "id";
	public static final String SHIP_MODEL = "shipModel";
	public static final String MANUFACTURER = "manufacturer";

}

