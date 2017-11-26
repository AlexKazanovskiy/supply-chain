package kpi.supplychain.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Main class that all DAO classes should extend.
 * Contain methods to manipulate with database records.
 * @param <T> - Type of entity mapped to database table.
 * @param <K> - Type of entity's primary key.
 */
@Repository
@Transactional
public abstract class DAO<T, K extends Serializable> {

    /**
     * Hibernate session factory.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * default constructor.
     */
    public DAO() {
    }

    /**
     * Session factory injecting constructor.
     * @param sessionFactory hibernate session factory.
     */
    public DAO(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Internal getter for hibernate session.
     * @return current session.
     */
    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Store given object into database.
     * @param o - Object to store.
     */
    protected Serializable generalCreate(final T o) {
        return (session().save(o));
    }

    /**
     * Updates entity that matches the given object.
     * @param o - Object.
     */
    protected void generalUpdate(final T o) {
        session().update(o);
    }

    /**
     * Deletes entity that matches given object.
     * @param o - Object.
     */
    protected void generalRemove(final T o) {
        session().delete(o);
    }

    /**
     * Retrieves list of entities from database.
     * @param type - class of mapped entity.
     * @return list of entities.
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    protected List<T> list(final Class<T> type) {
        return session().createCriteria(type).list();
    }

    /**
     * Retrieves entity from database by ID.
     * @param type class of mapped entity.
     * @param key id.
     * @return entity object.
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    protected T selectById(
                      final Class<T> type,
                      final K key) {
        return (T) session().get(type, key);
    }

    /**
     * Retrieves entity from database by specified column.
     * @param type class of mapped entity.
     * @param fieldName name of column.
     * @param fieldValue value of column.
     * @return entity object.
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    protected List<T> selectByField(
                      final Class<T> type,
                      final String fieldName,
                      final Object fieldValue) {
        Criteria criteria  = session().createCriteria(type);
        criteria.add(Restrictions.eq(fieldName, fieldValue));
        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    protected T selectByUniqueField(
            final Class<T> type,
            final String fieldName,
            final String fieldValue) {
        Criteria criteria  = session().createCriteria(type);
        criteria.add(Restrictions.eq(fieldName, fieldValue));
        return (criteria.list().isEmpty())
                ? null
                : (T) criteria.list().get(0);
    }
}
