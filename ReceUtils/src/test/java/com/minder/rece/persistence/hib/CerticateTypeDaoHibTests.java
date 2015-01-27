package com.minder.rece.persistence.hib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.minder.rece.domain.CertificateType;
import com.minder.rece.persistence.CertificateTypeDao;

public class CerticateTypeDaoHibTests {
	
	private static CertificateType certificateType;
	private static CertificateTypeDao certificateTypeDao;
	
	@BeforeClass
	public static void setup() {
		certificateType = new CertificateType();
		certificateType.setName("A");
		certificateType.setDescription("Certificado Tipo A");
		certificateTypeDao = new CertificateTypeDaoHib();
	}

	@Test
	public void testSave() {
		try {
			int totalSize = certificateTypeDao.findAll().size();
			int nameSize = certificateTypeDao.findByName("A").size();
			certificateTypeDao.save(certificateType);
			List<CertificateType> results = certificateTypeDao.findByName("A");
			assertEquals(totalSize+1, certificateTypeDao.findAll().size());
			assertEquals(nameSize+1, results.size());
			assertEquals("Certificado Tipo A", results.get(0).getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e.getMessage());
		}
	}
}
