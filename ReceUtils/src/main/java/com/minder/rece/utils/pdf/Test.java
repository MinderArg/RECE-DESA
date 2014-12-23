package com.minder.rece.utils.pdf;

import java.util.HashMap;
import java.util.Map;

import com.minder.rece.utils.splitter.FillFields;

@SuppressWarnings("unused")
public class Test {

	///// ARCHIVOS PARA PRUEBA DE CARGA /////
	private final static String FILE_C1 = "Lote de Prueba/Apaisado/Liquidacion560Recibos.pdf";
	private final static String FILE_C2 = "Lote de Prueba/Apaisado/Liquidacion1120Recibos.pdf";
	private final static String FILE_C3 = "Lote de Prueba/Apaisado/Liquidacion2240Recibos.pdf";
	private final static String FILE_C4 = "Lote de Prueba/Apaisado/Liquidacion4480Recibos.pdf";
	
	///// ARCHIVOS PARA PRUEBA DE SPLITTER /////
	private final static String FILE_S1 = "Lote de Prueba/Minder/recibo.pdf";
	private final static String FILE_S2 = "Lote de Prueba/Apaisado/Falabella.pdf";
	
	///// ARCHIVOS PARA PRUEBA DE FILLFIELDS /////
	private final static String FILE_F1 = "Lote de Prueba/Acepto/Minder_acepto.pdf";
	private final static String FILE_F2 = "Lote de Prueba/Acepto/Yel_acepto.pdf";
	
	///// FIN ARCHIVOS /////

	private static RecePDF pdf;

	public static void main(String[] args) {
		pdf = new RecePDF("Liquidacion560Recibos.pdf");
		
		testSplitDocument();
		//testFillFields("map");
		
		pdf.closeDocument();
	}
	
	private static void testSplitDocument() {
		Splitter.splitDocument(pdf);
	}
	
	private static void testFillFields(String prueba) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Day", "22");
		map.put("Month", "05");
		map.put("Year", "2014");
		map.put("PublicKey", "CLAVE-PÚBLICA");
		map.put("Name", "Mohamed");
		map.put("Surname", "Lee");
		map.put("Cuil", "20-12345678-0");
		switch (prueba) {
		case "map":
			FillFields.fillMapFields(pdf, map);
			break;
		case "all":
			FillFields.fillAllFields(pdf, map);
			break;
		}
	}
}
