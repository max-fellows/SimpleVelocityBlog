package main.java.service;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class PersistenceService<T> {

	@PersistenceContext(unitName="VelocityBlog")
	protected EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	abstract public T find(Integer id);
	
}
