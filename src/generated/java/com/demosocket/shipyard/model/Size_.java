package com.demosocket.shipyard.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Size.class)
public abstract class Size_ {

	public static volatile CollectionAttribute<Size, Ship> ships;
	public static volatile SingularAttribute<Size, Integer> size_id;

	public static final String SHIPS = "ships";
	public static final String SIZE_ID = "size_id";

}

