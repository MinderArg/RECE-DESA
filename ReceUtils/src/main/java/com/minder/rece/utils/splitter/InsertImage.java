package com.minder.rece.utils.splitter;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;

import com.minder.rece.utils.pdf.RecePDF;

@SuppressWarnings("unused")
public class InsertImage {

	private final static String FILE_S1 = "Lote de Prueba/Minder/recibo.pdf";
	private final static String IMG_1 = "Lote de Prueba/img/browsers.jpg";
	private final static String IMG_2 = "Lote de Prueba/img/minder.png";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		RecePDF doc = new RecePDF(FILE_S1);
		/*
		 * JFreeChart chart = new JFreeChart(new Plo); try { PDPageContentStream
		 * content = new PDPageContentStream(doc.getDocument(), doc.getPage(1));
		 * BufferedImage image = chart.createBufferedImage(300, 300); ximage =
		 * new PDJpeg(doc, image); content.drawImage(ximage, 20, 20);
		 * content.close(); } catch(IOException ie) { }
		 */
		/*
		if (doc.getNumberOfPages() > 0) {
			PDJpeg img;
			try {
				img = new PDJpeg(doc.getDocument(), new FileInputStream(IMG_1));
				PDPageContentStream stream = new PDPageContentStream(doc.getDocument(), doc.getPage(1));
				stream.drawImage(img, 20, 20);
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error");
			}
		}
		*/
		try {
			BufferedImage bufferIMG = ImageIO.read(new File(IMG_1));
			PDPageContentStream contentStream = new PDPageContentStream(doc.getDocument(), doc.getPage(1));
			PDJpeg image = new PDJpeg(doc.getDocument(), bufferIMG); 
			contentStream.drawXObject(image, 20, 20, 5, 5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
		}
				
		doc.saveDocument(doc.getPathWithTag("-IMG"));
		doc.closeDocument();
	}
}
