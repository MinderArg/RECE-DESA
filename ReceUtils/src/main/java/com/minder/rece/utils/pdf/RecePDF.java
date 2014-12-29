package com.minder.rece.utils.pdf;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.*;
import org.apache.pdfbox.pdmodel.*;

import com.minder.rece.utils.certificate.CertificateManager;
import com.minder.rece.utils.pdf.signature.DocumentSigner;

public class RecePDF {
	// ATTRIBUTES
	private PDDocument document;
	private String name;
	private String ext;
	private String path;
	private Boolean doublePage;

	// CONSTRUCTORS
	public RecePDF(String filePath) {
		this(filePath, false);
	}

	public RecePDF(String filePath, boolean doublePage) {
		path = filePath;
		try {
			document = PDDocument.load(path);
		} catch (IOException e) {
			// TODO: Use Log
			System.out.println("Error: Invalid File Path.");
		}

		System.out.println(File.separator);
		System.out.println(path);

		String[] parsed = path.split("/");
		if (parsed.length >= 1) {
			String[] file = parsed[parsed.length - 1].split("\\.");
			if (file.length >= 2) {
				ext = file[file.length - 1];
				name = parsed[parsed.length - 1].substring(0,
						parsed[parsed.length - 1].length() - ext.length() - 1);
			}
		}
		this.doublePage = doublePage;
	}

	public RecePDF(RecePDF doc) {
		document = doc.getDocument();
		name = doc.getName();
		path = doc.getPath();
		doublePage = doc.getDoublePage();
	}

	// GETTERS Y SETTERS
	public PDDocument getDocument() {
		return document;
	}

	public void setDocument(PDDocument document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getDoublePage() {
		return doublePage;
	}

	public void setDoublePage(Boolean doublePage) {
		this.doublePage = doublePage;
	}

	// FILE MANAGEMENT
	public void closeDocument() {
		try {
			document.close();
		} catch (IOException e) {
			// TODO: Use Log
			System.out.println("Error al cerrar el documento. " + e.toString());
		}
	}

	public void saveDocument(String destPath) {
		try {
			document.save(destPath);
		} catch (COSVisitorException | IOException e) {
			// TODO: Use Log
			System.out.println("Error al guardar el archivo \"" + destPath + "\". " + e.toString());
		}
	}

	public static void saveDocument(PDDocument doc, String destPath) {
		try {
			doc.save(destPath);
			doc.close();
		} catch (COSVisitorException | IOException e) {
			// TODO: Use Log
			System.out.println("Error al guardar el archivo \"" + destPath + "\". " + e.toString());
		}
	}

	public String getPathWithTag(String tag) {
		return path.replace(name, name + tag);
	}

	// CONTENT Readers
	public PDPage getPage(int index) {
		return (PDPage) document.getDocumentCatalog().getAllPages().get(index - 1);
	}

	public int getNumberOfPages() {
		return document.getDocumentCatalog().getAllPages().size();
	}

	// CONTENT Modifiers
	public void splitDocument() {
		Splitter.splitDocument(this);
	}

	// CERTIFICATE / SIGNATURE
	public String getSignatureInfo(String password)
			throws Exception {
		return CertificateManager.getSignatureInfoFromFile(password, this);
	}

	public RecePDF sign(String nameToPutToTheSing, String reasonToPutToTheSing,
			String locationToPutToTheSing, int signatureSize, String certificateLocation,
			String certificatePassword, String provider, String keyStoreType, String hashAlgorithm,
			String dest, String pathImageSign, int xAxisPosition, int yAxisPosition) {
		return sign(new DocumentSigner(nameToPutToTheSing, reasonToPutToTheSing, locationToPutToTheSing,
				signatureSize, certificateLocation, certificatePassword, provider, keyStoreType,
				hashAlgorithm), dest, pathImageSign, xAxisPosition, yAxisPosition);
	}

	public RecePDF sign(DocumentSigner signer, String dest, String pathImageSign, int xAxisPosition,
			int yAxisPosition) {
		signer.signPdf(this, dest, pathImageSign, xAxisPosition, yAxisPosition);
		return new RecePDF(dest);
	}
}
