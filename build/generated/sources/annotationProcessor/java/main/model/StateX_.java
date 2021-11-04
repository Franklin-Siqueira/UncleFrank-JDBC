package model;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StateX.class)
public abstract class StateX_ {

	public static volatile SingularAttribute<StateX, String> symbol;
	public static volatile ListAttribute<StateX, StudentX> alunos;
	public static volatile SingularAttribute<StateX, String> name;
	public static volatile SingularAttribute<StateX, Integer> id;

	public static final String SYMBOL = "symbol";
	public static final String ALUNOS = "alunos";
	public static final String NAME = "name";
	public static final String ID = "id";

}

