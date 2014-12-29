package com.minder.rece.utils.certificate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Date;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;

import com.minder.rece.utils.pdf.RecePDF;

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

public class CertificateManager {

	private CertificateManager() {
	}

	public static String decryptPassword(String encryptedPassword) {
		return Encrypter.decrypt(encryptedPassword);
	}

	public static String encryptPassword(String decryptedPassword) {
		return Encrypter.encrypt(decryptedPassword);
	}

	/**
	 * Create a self-signed X.509 Certificate
	 * 
	 * @param dn
	 *            the X.509 Distinguished Name, eg "CN=Test, L=London, C=GB"
	 * @param pair
	 *            the KeyPair
	 * @param days
	 *            how many days from now the Certificate is valid for
	 * @param algorithm
	 *            the signing algorithm, eg "SHA1withRSA"
	 */
	public static X509Certificate generateCertificate(String dn, int days)
			throws GeneralSecurityException, IOException {

		String algorithm = "SHA1withRSA";

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(2048);
		KeyPair pair = kpg.genKeyPair();

		PrivateKey privkey = pair.getPrivate();
		X509CertInfo info = new X509CertInfo();
		Date from = new Date();
		Date to = new Date(from.getTime() + days * 86400000l);
		CertificateValidity interval = new CertificateValidity(from, to);
		BigInteger sn = new BigInteger(64, new SecureRandom());
		X500Name owner = new X500Name(dn);

		info.set(X509CertInfo.VALIDITY, interval);
		info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
		info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(owner));
		info.set(X509CertInfo.ISSUER, new CertificateIssuerName(owner));
		info.set(X509CertInfo.KEY, new CertificateX509Key(pair.getPublic()));
		info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
		AlgorithmId algo = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
		info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

		// Sign the cert to identify the algorithm that's used.
		X509CertImpl cert = new X509CertImpl(info);
		cert.sign(privkey, algorithm);

		// Update the algorith, and resign.
		algo = (AlgorithmId) cert.get(X509CertImpl.SIG_ALG);
		info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);
		cert = new X509CertImpl(info);
		cert.sign(privkey, algorithm);
		return cert;
	}

	public static String getSignatureInfoFromFile(String password, RecePDF receDoc)
			throws Exception {

		String ret = "SIGNATURE INFO:\n";
		PDDocument document = null;

		try {
			document = receDoc.getDocument();

			if (document.isEncrypted()) {
				document.decrypt(password);
			} else {
				ret += "\nWarning: Document is not encrypted.";
			}

			COSDictionary trailer = document.getDocument().getTrailer();
			COSDictionary root = (COSDictionary) trailer.getDictionaryObject(COSName.ROOT);
			COSDictionary acroForm = (COSDictionary) root.getDictionaryObject(COSName.ACRO_FORM);
			COSArray fields = (COSArray) acroForm.getDictionaryObject(COSName.FIELDS);

			for (int i = 0; i < fields.size(); i++) {

				COSDictionary field = (COSDictionary) fields.getObject(i);
				String type = field.getNameAsString("FT");

				if ("Sig".equals(type)) {

					COSDictionary cert = (COSDictionary) field.getDictionaryObject(COSName.V);

					if (cert != null) {

						ret += "\nCertificate found";
						ret += "\nName=" + cert.getDictionaryObject(COSName.NAME);
						ret += "\nModified=" + cert.getDictionaryObject(COSName.getPDFName("M"));
						COSName subFilter = (COSName) cert.getDictionaryObject(COSName
								.getPDFName("SubFilter"));

						if (subFilter != null) {
							if (subFilter.getName().equals("adbe.x509.rsa_sha1")) {

								COSString certString = (COSString) cert.getDictionaryObject(COSName
										.getPDFName("Cert"));
								byte[] certData = certString.getBytes();
								CertificateFactory factory = CertificateFactory.getInstance("X.509");
								ByteArrayInputStream certStream = new ByteArrayInputStream(certData);
								Collection<? extends Certificate> certs = factory
										.generateCertificates(certStream);
								ret += "\ncerts=" + certs;

							} else if (subFilter.getName().equals("adbe.pkcs7.sha1")) {

								COSString certString = (COSString) cert.getDictionaryObject(COSName.CONTENTS);
								byte[] certData = certString.getBytes();
								CertificateFactory factory = CertificateFactory.getInstance("X.509");
								ByteArrayInputStream certStream = new ByteArrayInputStream(certData);
								Collection<? extends Certificate> certs = factory
										.generateCertificates(certStream);
								ret += "\ncerts=" + certs;

							} else if (subFilter.getName().equals("adbe.pkcs7.detached")) {

								COSString certString = (COSString) cert.getDictionaryObject(COSName.CONTENTS);
								byte[] certData = certString.getBytes();
								CertificateFactory factory = CertificateFactory.getInstance("X.509");
								ByteArrayInputStream certStream = new ByteArrayInputStream(certData);
								Collection<? extends Certificate> certs = factory
										.generateCertificates(certStream);
								ret += "\ncerts=" + certs;

							} else {

								ret += "\nUnknown certificate type:" + subFilter;

							}
						} else {

							receDoc.closeDocument();
							throw new IOException("Missing subfilter for cert dictionary");

						}
					} else {

						ret += "\nSignature found, but no certificate";

					}
				}
			}
		} finally {

			if (document != null) {
				receDoc.closeDocument();
			}
		}

		return ret;
	}

}