
package com.minder.rece.utils.signer;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

import java.util.Collection;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;

import org.apache.pdfbox.pdmodel.PDDocument;


public class SignatureManager {

	private SignatureManager() {
	}

	public static String getSignatureInfoFromFile(String password, String infile) throws Exception {
		
		String ret="SIGNATURE INFO:\n";
		PDDocument document = null;

		try {
			document = PDDocument.load(infile);

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
						COSName subFilter = (COSName) cert.getDictionaryObject(COSName.getPDFName("SubFilter"));
						
						if (subFilter != null) {
							if (subFilter.getName().equals("adbe.x509.rsa_sha1")) {
								
								COSString certString = (COSString) cert.getDictionaryObject(COSName.getPDFName("Cert"));
								byte[] certData = certString.getBytes();
								CertificateFactory factory = CertificateFactory.getInstance("X.509");
								ByteArrayInputStream certStream = new ByteArrayInputStream(certData);
								Collection<? extends Certificate> certs = factory.generateCertificates(certStream);
								ret += "\ncerts=" + certs;
								
							} else if (subFilter.getName().equals("adbe.pkcs7.sha1")) {
								
								COSString certString = (COSString) cert.getDictionaryObject(COSName.CONTENTS);
								byte[] certData = certString.getBytes();
								CertificateFactory factory = CertificateFactory.getInstance("X.509");
								ByteArrayInputStream certStream = new ByteArrayInputStream(certData);
								Collection<? extends Certificate> certs = factory.generateCertificates(certStream);
								ret += "\ncerts=" + certs;
								
							} else {
								
								ret += "\nUnknown certificate type:" + subFilter;
								
							}
						} else {
							
							document.close();
							throw new IOException("Missing subfilter for cert dictionary");
							
						}
					} else {
						
						ret += "\nSignature found, but no certificate";
						
					}
				}
			}
		} finally {
			
			if (document != null) {
				document.close();
			}
		}

		return ret;
	}

}