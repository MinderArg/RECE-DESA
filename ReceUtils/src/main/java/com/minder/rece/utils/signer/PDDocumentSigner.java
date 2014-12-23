package com.minder.rece.utils.signer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.SignatureException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureInterface;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSigProperties;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible.PDVisibleSignDesigner;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JcaSignerInfoGeneratorBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.util.Store;

public class PDDocumentSigner implements SignatureInterface {

	
	private static final String PROVIDER_BC = "BC";
	private static final String KEYSTORE_TYPE_PKCS12 = "PKCS12";
	private static final String HASH_ALGORITHM_SHA256 = "SHA-256";

	private PrivateKey privateKey;
	private Certificate[] chain;

	private String provider;
	private String keyStoreType;
	private String hashAlgorithm;

	private String password;
	private String keyStoreLocation;

	private String name;
	private String reason;
	private String location;
	private int sinatureSize;

	private void init(String nameToPutToTheSing, String reasonToPutToTheSing,
			String locationToPutToTheSing, int signatureSize,
			String certificateLocation, String certificatePassword,
			String provider, String keyStoreType, String hashAlgorithm) {
		if (provider.isEmpty())
			this.provider = PROVIDER_BC;

		if (keyStoreType.isEmpty())
			this.keyStoreType = KEYSTORE_TYPE_PKCS12;

		if (hashAlgorithm.isEmpty())
			this.hashAlgorithm = HASH_ALGORITHM_SHA256;

		keyStoreLocation = certificateLocation;
		password = certificatePassword;
		this.name = nameToPutToTheSing;
		this.reason = reasonToPutToTheSing;
		this.location = locationToPutToTheSing;
		this.sinatureSize = signatureSize;

	}

	private String getProvider() {
		return this.provider;
	}

	private String getKeyStoreType() {
		return this.keyStoreType;
	}

	private String getKeyStoreLocation() {

		return this.keyStoreLocation;
	}

	private String getPassword() {

		return this.password;
	}

	private String getName() {

		return this.name;
	}

	private String getReason() {

		return this.reason;
	}

	private String getLocation() {

		return this.location;
	}

	private int getSignatureSize() {

		return this.sinatureSize;
	}

	public PDDocumentSigner(String nameToPutToTheSing,
			String reasonToPutToTheSing, String locationToPutToTheSing,
			int sinatureSize, String certificateLocation,
			String certificatePassword, String provider, String keyStoreType,
			String hashAlgorithm) {

		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

		init(nameToPutToTheSing, reasonToPutToTheSing, locationToPutToTheSing,
				sinatureSize, certificateLocation, certificatePassword,
				provider, keyStoreType, hashAlgorithm);

		try {
			KeyStore keystore = KeyStore.getInstance(getKeyStoreType(),
					getProvider());

			InputStream input = new FileInputStream(getKeyStoreLocation());

			keystore.load(input, getPassword().toCharArray());
			Enumeration<String> aliases = keystore.aliases();
			String alias = null;
			if (aliases.hasMoreElements())
				alias = aliases.nextElement();
			else
				throw new RuntimeException("Could not find Key");

			privateKey = (PrivateKey) keystore.getKey(alias, getPassword()
					.toCharArray());

			chain = keystore.getCertificateChain(alias);
		} catch (KeyStoreException | NoSuchProviderException | IOException
				| NoSuchAlgorithmException | CertificateException
				| UnrecoverableKeyException e) {
			throw new RuntimeException(
					"Error while loading certificates and private key", e);
		}

	}

	public void signPdf(String src, String dest, String pathImageSign,
			int xAxisPosition, int yAxisPosition) {
		try {
			File document = new File(src);
			File outputDocument = new File(dest);

			FileInputStream fis = new FileInputStream(document);
			FileOutputStream fos = new FileOutputStream(outputDocument);

			byte[] buffer = new byte[8 * 1024];
			int c;
			while ((c = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, c);
			}
			fis.close();
			fis = new FileInputStream(outputDocument);

			PDDocument doc = PDDocument.load(document);

			PDSignature signature = new PDSignature();

			// default filter
			signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);

			// subfilter for basic and PAdES Part 2 signatures
			signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
			signature.setName(getName());
			signature.setReason(getReason());
			signature.setLocation(getLocation());

			// the signing date, needed for valid signature
			Calendar cal = Calendar.getInstance();
			signature.setSignDate(cal);

			SignatureOptions signatureOptions = new SignatureOptions();
			signatureOptions.setPreferedSignatureSize(getSignatureSize());

			if (!pathImageSign.isEmpty()) {

				FileInputStream image = new FileInputStream(pathImageSign);
				
				//BufferedImage image = ImageIO.read(new File(pathImageSign));
				

				PDVisibleSignDesigner visibleSig = new PDVisibleSignDesigner(
						src, image, 1);
				visibleSig.xAxis(xAxisPosition).yAxis(yAxisPosition)
						.signatureFieldName("signature");

				PDVisibleSigProperties signatureProperties = new PDVisibleSigProperties();

				signatureProperties.signerName("name")
						.signerLocation("location").signatureReason("Security")
						.preferredSize(0).page(1).visualSignEnabled(true)
						.setPdVisibleSignature(visibleSig).buildSignature();// ver
																			// método
																			// .size

				signatureOptions.setVisualSignature(signatureProperties);

			}

			doc.addSignature(signature, this, signatureOptions);

			// write incremental (only for signing purpose)
			doc.saveIncremental(fis, fos);

			// Close document
			doc.close();
		} catch (IOException | SignatureException | COSVisitorException e) {
			throw new RuntimeException("Error while signing pdf", e);
		}
	}

	public byte[] sign(InputStream content) throws SignatureException,
			IOException {
		byte[] c = IOUtils.toByteArray(content);
		try {
			// general class for generating a pkcs7-signature message
			CMSSignedDataGenerator gen = new CMSSignedDataGenerator();

			ContentSigner signer = new JcaContentSignerBuilder("SHA256withRSA")
					.setProvider(getProvider()).build(privateKey);

			gen.addSignerInfoGenerator(new JcaSignerInfoGeneratorBuilder(
					new JcaDigestCalculatorProviderBuilder().setProvider(
							getProvider()).build()).build(signer,
					(X509Certificate) chain[0]));

			Store certs = new JcaCertStore(Arrays.asList(chain));
			gen.addCertificates(certs);

			CMSTypedData msg = new CMSProcessableByteArray(c);
			// encapsulate false: carrying a detached CMS signature.
			CMSSignedData signedData = gen.generate(msg, false);

			// Transcode BER to DER
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			new DEROutputStream(baos).writeObject(signedData.toASN1Structure());
			return baos.toByteArray();

		} catch (Exception e) {
			// should be handled
			System.err.println("Error while creating pkcs7 signature.");
			e.printStackTrace();
		}
		throw new RuntimeException("Problem while preparing signature");

	}
	
}
