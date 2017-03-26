package ua.com.springtest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T, PK extends Serializable> {

    private final Class persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    public T getById(PK id) {
        return (T) getSession().get(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) getSession().createCriteria(persistentClass).list();
    }

    @SuppressWarnings("unchecked")
    public T save(T entity) {
        getSession().persist(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public void delete(PK id) {
        T entity = getById(id);
        if (entity != null) {
            getSession().delete(entity);
        }
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
