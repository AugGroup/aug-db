
/**
 *
 * @author Ekkachai.K
 * @date 2 December 2014
 */
package com.aug.hrdb.repositories.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.aug.hrdb.repositories.GenericRepository;


public class GenericRepositoryImpl<E, I extends Serializable> implements GenericRepository<E, I> {

    private Class<E> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericRepositoryImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() throws DataAccessException {
        return getCurrentSession().createCriteria(entityClass).list();
    }

    @SuppressWarnings("unchecked")
    public E find(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public void create(E e) {
        getCurrentSession().save(e);
    }

    public void update(E e)  {
        getCurrentSession().update(e);
    }

    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    public void deleteById(I id){
    	delete(find(id));
    }
    
    public void flush() {
        getCurrentSession().flush();
    }

}
