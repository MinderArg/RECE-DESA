package com.minder.rece.utils.splitter;

import java.awt.image.BufferedImage;
import java.io.IOException;

import com.minder.rece.utils.pdf.RecePDF;

/**
 * Servicio que se encarga de convertir un documento PDF en imágenes PNG.
 * @author Lucas Ponce de León
 */
public class ConvertPDFtoPNG {
	
	private final static String FILE_S1 = "Lote de Prueba/Minder/recibo.pdf";
	
	@SuppressWarnings("unused")
	public static void main(String[]args) {
		RecePDF pdf = new RecePDF(FILE_S1);
		try {
			if ( pdf.getNumberOfPages() > 0 ) {
				BufferedImage img = pdf.getPage(1).convertToImage();
				// TODO: Completar metodo
			}
		} catch (IOException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
}