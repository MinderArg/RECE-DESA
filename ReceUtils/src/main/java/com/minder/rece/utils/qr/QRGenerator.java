package com.minder.rece.utils.qr;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRGenerator {
	public static void generateMECardQRCode(String filename, MECard meCard) {

		String data = "MECARD:";
		data += "N:" + meCard.getName() + ";";
		data += "TEL:" + meCard.getTel() + ";";
		data += "NOTE:" + meCard.getNote() + ";";
		data += "EMAIL:" + meCard.getEmail() + ";";
		data += ";";

		generateQRCode(filename, data);
	}

	public static void generateQRCode(String filename, String data) {

		ByteArrayOutputStream out = QRCode.from(data).withSize(600, 600).to(ImageType.PNG).stream();

		try {
			FileOutputStream fout = new FileOutputStream(new File(filename));

			fout.write(out.toByteArray());

			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
