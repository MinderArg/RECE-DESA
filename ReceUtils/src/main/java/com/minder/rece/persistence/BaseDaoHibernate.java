package com.minder.rece.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.minder.rece.domain.CertificateType;

@SuppressWarnings("unchecked")
public abstract class BaseDaoHibernate<T extends Serializable, E> implements BaseDao<T, E> {
	
	@Autowired
	public SessionFactory sessionFactory;

	@Transactional
	public void deleteAll(final Collection<T> instances) throws Exception {
		try {
			for (Iterator<T> iterator = instances.iterator(); iterator.hasNext();)
				sessionFactory.getCurrentSession().delete(iterator.next());
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
			final List<T> result = sessionFactory.getCurrentSession().createCriteria(CertificateType.class).add(Example.create(instance)).list();
			return result;
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
			final List<Map<String, Object>> results = (List<Map<String, Object>>) sessionFactory.getCurrentSession().createQuery(queryString);
			return results;
		} catch (final Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public List<T> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(CertificateType.class).list();
	}

	@Transactional
	public abstract T findById(E id) throws Exception;
}