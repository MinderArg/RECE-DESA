package com.minder.rece.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public abstract class BaseDaoHibernate<T extends Serializable, E> implements BaseDao<T, E> {
	
	@Autowired
	public SessionFactory sessionFactory;

	@Transactional
	public void deleteAll(final Collection<T> instances) throws Exception {
		try {
			//TODO: Implement it!
			//getHibernateTemplate().deleteAll(instances);
		} catch (final Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public int bulkUpdate(final String query) throws Exception {
		try {
			//TODO: Implement it!
			return 0;
			//return getHibernateTemplate().bulkUpdate(query);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public E save(final T instance) throws Exception {
		try {
			return (E) sessionFactory.getCurrentSession().save(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public void saveOrUpdate(final T instance) throws Exception {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public void persist(final T transientInstance) throws Exception {
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public void attachDirty(final T instance) throws Exception {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public void attachClean(final T instance) throws Exception {
		try {
			sessionFactory.getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public void delete(final T persistentInstance) throws Exception {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public T merge(final T detachedInstance) throws Exception {
		try {
			final T result = (T) sessionFactory.getCurrentSession().merge(detachedInstance);
			return result;
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public List<T> findByExample(final T instance) throws Exception {
		try {
			//TODO: Implement it!
			return null;
			//final List<T> results = getHibernateTemplate().findByExample(instance);
			//return results;
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public List<T> findByQuery(final String queryString) throws Exception {
		try {
			final List<T> results = sessionFactory.getCurrentSession().createQuery(queryString).list();
			return results;
		} catch (final Exception e) {
			throw e;
		}
	}

	@Transactional
	public List<Map<String, Object>> findMapByQuery(final String queryString)
			throws Exception {
		try {
			//TODO: Implement it!
			return null;
			//final List<Map<String, Object>> results = (List<Map<String, Object>>) getHibernateTemplate().find(queryString);
			//return results;
		} catch (final Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public abstract List<T> findAll() throws Exception;

	@Transactional
	public abstract T findById(E id) throws Exception;
}