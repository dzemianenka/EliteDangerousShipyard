package com.demosocket.shipyard.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Manufacturer.class)
public abstract class Manufacturer_ {

	public static volatile SingularAttribute<Manufacturer, Integer> manufacturer_id;
	public static volatile CollectionAttribute<Manufacturer, Ship> manufacturer;

	public static final String MANUFACTURER_ID = "manufacturer_id";
	public static final String MANUFACTURER = "manufacturer";

}

