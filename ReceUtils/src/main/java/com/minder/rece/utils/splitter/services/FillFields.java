package com.minder.rece.utils.splitter.services;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import com.minder.rece.utils.splitter.objects.RecePDF;

public class FillFields {
	
	public static void fillMapFields(RecePDF doc, Map<String,String> map) {
		PDAcroForm acro = doc.getDocument().getDocumentCatalog().getAcroForm();
		Set<String> fields = map.keySet();
		try {
			for (Iterator<String> it = fields.iterator(); it.hasNext();) {
				String fieldName = it.next();
				PDField field = acro.getField(fieldName);
				if ( field != null ) {
					field.setValue(map.get(fieldName));
					field.setReadonly(true);
				}
				else
					//TODO: Use Log
					System.out.println("Error: El campo \"" + field + "\" no existe.");
			}		
			doc.saveDocument(doc.getPathWithTag("-FILL"));
		} catch (IOException e) {
			//TODO: Use Log
			System.out.println("Error al leer campos del archivo \"" + doc.getPath() + "\". " + e.toString());
		}
	}
	
	public static void fillAllFields(RecePDF doc, Map<String,String> map) {
		PDAcroForm acro = doc.getDocument().getDocumentCatalog().getAcroForm();
		try {
			@SuppressWarnings("unchecked")
			List<PDField> fields = acro.getFields();
			for (Iterator<PDField> it = fields.iterator(); it.hasNext();) {
				PDField field = it.next();
				if ( field != null ) {
					field.setValue(map.get(field.getFullyQualifiedName()));
					field.setReadonly(true);
				}
				else
					//TODO: Use Log
					System.out.println("Error: El campo \"" + field + "\" no existe.");
			}		
			doc.saveDocument(doc.getPathWithTag("-FILL"));
		} catch (IOException e) {
			//TODO: Use Log
			System.out.println("Error al leer campos del archivo \"" + doc.getPath() + "\". " + e.toString());
		}
	}
}
