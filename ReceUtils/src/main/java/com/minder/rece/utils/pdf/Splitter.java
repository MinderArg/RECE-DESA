package com.minder.rece.utils.pdf;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.PDFTextStripper;

public class Splitter {

	public static void splitDocument(RecePDF doc) {

		RecePDF.saveDocument(doc.getDocument(), doc.getPathWithTag("-TEST"));
		
//		System.out.println("-----------Iniciando formateo del documento.-----------");
//		if (doc.getDoublePage()) {
//			System.out.println("-----------Iniciando corte del documento.-----------");
//			cutPages(doc);
//		}
//
//		System.out.println("-----------Iniciando spliteo del documento.-----------");
//		try {
//			splitCUIL(doc);
//		} catch (IOException e) {
//			System.out.println("Problema en splitCUIL.");
//			e.printStackTrace();
//		}

		System.out.println("-----------Fin del formateo del documento.-----------");
	}

	/**
	 * Corta por la mitad las páginas del PDF que tienen formato doble.
	 * 
	 * @param doc
	 *            Documento a cortar.
	 * @author Lucas Ponce de León
	 */
	private static void cutPages(RecePDF doc) {
		try {
			PDDocument docCopy = new PDDocument();
			for (int actPage = 1; actPage <= doc.getNumberOfPages(); actPage++) {
				docCopy.importPage(doc.getPage(actPage));
				docCopy.importPage(doc.getPage(actPage));
			}
			
			PDDocument cutDoc = new PDDocument();
			for (int actPage = 1; actPage <= doc.getNumberOfPages()*2; actPage++) {
				PDPage page = (PDPage) docCopy.getDocumentCatalog().getAllPages().get(actPage - 1);
				PDRectangle rectangle = new PDRectangle();
				rectangle.setUpperRightY(page.findCropBox().getUpperRightY());
				rectangle.setLowerLeftY(page.findCropBox().getLowerLeftY());
				if (actPage % 2 == 1) {
					// Página Izquierda
					rectangle.setUpperRightX(page.findCropBox().getUpperRightX() / 2);
					rectangle.setLowerLeftX(page.findCropBox().getLowerLeftX());
				} else {
					// Página Derecha
					rectangle.setUpperRightX(page.findCropBox().getUpperRightX());
					rectangle.setLowerLeftX(page.findCropBox().getUpperRightX() / 2
							+ page.findCropBox().getLowerLeftX());
				}
				page.setCropBox(rectangle);
				cutDoc.addPage(page);
			}
			docCopy.close();
			RecePDF.saveDocument(cutDoc, doc.getPathWithTag("-CUT"));
			doc.closeDocument();
			doc.setDocument(PDDocument.load(doc.getPathWithTag("-CUT")));

			/*
			 * PRUEBA 2 PDDocument cutDoc = new PDDocument();
			 * cutDoc.addPage(getPage(1)); cutDoc.addPage(getPage(2));
			 * cutDoc.addPage(getPage(3)); cutDoc.addPage(getPage(4));
			 * cutDoc.addPage(getPage(5)); cutDoc.addPage(getPage(6));
			 * //saveDocument(cutDoc, pathWithTag("-DANY"));
			 * 
			 * System.out.println(doc.); System.out.println("---------------");
			 * closeDocument(); doc = cutDoc;
			 * System.out.println(doc.getNumberOfPages());
			 * System.out.println(doc
			 * .getDocumentCatalog().getPages().getCount());
			 * System.out.println(doc
			 * .getDocumentCatalog().getAllPages().size()); //getPage(2);
			 * //System.out.println(doc.getNumberOfPages());
			 * //saveDocument(cutDoc, pathWithTag("-CUT"));
			 */
		} catch (IOException e) {
			System.out.println("Error al cortar las páginas. " + e.toString());
		}
	}

	private static void splitCUIL(RecePDF doc) throws IOException {
		int cantDoc = 0, firstCUILPage = 0;
		String prevCUIL = "-";

		System.out.println("Cantidad de páginas del documento: " + doc.getNumberOfPages());

		for (int actPage = 1; actPage <= doc.getNumberOfPages(); actPage++) {
			String actCUIL = getCUIL(doc, actPage);
			if (!actCUIL.equals(prevCUIL) || actPage==doc.getNumberOfPages()) {
				if (firstCUILPage != 0) {
					int pages = actPage - firstCUILPage;
					PDDocument oriDoc, dupDoc;
					oriDoc = new PDDocument();
					dupDoc = new PDDocument();
					if (doc.getDoublePage()) { // Página Doble
						// Generar PDF Recibos Original
						for (int i = firstCUILPage; i < firstCUILPage + pages; i += 2)
							oriDoc.importPage(doc.getPage(i));
						// Generar PDF Recibos Duplicado
						for (int i = firstCUILPage + 1; i < firstCUILPage + pages; i += 2)
							dupDoc.importPage(doc.getPage(i));
					} else { // Página Simple
								// Generar PDF Recibos Original
						for (int i = firstCUILPage; i < firstCUILPage + pages / 2; i++)
							oriDoc.importPage(doc.getPage(i));
						// Generar PDF Recibos Duplicado
						for (int i = firstCUILPage + pages / 2; i < firstCUILPage + pages; i++)
							dupDoc.importPage(doc.getPage(i));
					}
					RecePDF.saveDocument(oriDoc, doc.getPathWithTag("-ORI-" + prevCUIL));
					RecePDF.saveDocument(dupDoc, doc.getPathWithTag("-DUP-" + prevCUIL));
					cantDoc++;
				}
				firstCUILPage = actPage;
			}
			prevCUIL = actCUIL;
			System.out.println("actPage: "+actPage);
			System.out.println("actCUIL: "+actCUIL);
		}
		// TODO: Quitar mensaje informativo
		System.out.println("Se procesaron " + cantDoc + " recibos.");
	}

	private static String getCUIL(RecePDF doc, int pageNum) {
		try {
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setStartPage(pageNum);
			stripper.setEndPage(pageNum);
			String text = stripper.getText(doc.getDocument());
			return matchRegex(text, "\\b2[0347]-?\\d{8}-?\\d\\b");
		} catch (IOException e) {
			// TODO: Use Log
			System.out.println("Error el obtener CUIL de página " + pageNum + " . " + e.toString());
			return null;
		}
	}

	private static String matchRegex(String text, String regexp) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(text);
		if (m.find())
			return text.substring(m.start(), m.end());
		else
			return "";
	}
}