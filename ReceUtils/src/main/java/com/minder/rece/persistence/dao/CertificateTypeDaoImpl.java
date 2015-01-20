package com.minder.rece.persistence.dao;

import java.util.List;

import com.minder.rece.domain.CertificateType;
import com.minder.rece.persistence.BaseDaoHibernate;

public class CertificateTypeDaoImpl extends BaseDaoHibernate<CertificateType , Integer> implements CertificateTypeDao {
		@Override
		public List<CertificateType> findAll() throws Exception {
			return getHibernateTemplate().loadAll(CertificateType.class);
		}
		@Override
		public CertificateType findById(Integer id) throws Exception {
			return getHibernateTemplate().get(CertificateType.class, id);
		}
}
