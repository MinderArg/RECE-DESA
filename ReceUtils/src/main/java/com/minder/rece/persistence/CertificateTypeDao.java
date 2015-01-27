package com.minder.rece.persistence;

import java.util.List;

import com.minder.rece.domain.CertificateType;
import com.minder.rece.persistence.BaseDao;

public interface CertificateTypeDao extends BaseDao<CertificateType, Integer> {
	public List<CertificateType> findByName(String name) throws Exception;
}