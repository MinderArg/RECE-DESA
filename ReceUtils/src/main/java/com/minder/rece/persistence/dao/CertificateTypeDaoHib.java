package com.minder.rece.persistence.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.minder.rece.domain.CertificateType;
import com.minder.rece.persistence.BaseDaoHibernate;
import com.minder.rece.utils.db.SessionMaker;

@SuppressWarnings("unchecked")
public class CertificateTypeDaoHib extends BaseDaoHibernate<CertificateType, Integer> implements CertificateTypeDao {
	
	//TODO: TEMPORAL
	public CertificateTypeDaoHib() {
		sessionFactory = SessionMaker.getSessionFactory();
	}
	
	@Override
	public List<CertificateType> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(CertificateType.class).list();
	}
	
	@Override
	public CertificateType findById(Integer id) throws Exception {
		//TODO: Implement it!
		return null;
		//return getHibernateTemplate().get(CertificateType.class, id);
	}
	
	@Override
	public List<CertificateType> findByName(String name) throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(CertificateType.class).add(Restrictions.eq("name", name)).list();
	}
}