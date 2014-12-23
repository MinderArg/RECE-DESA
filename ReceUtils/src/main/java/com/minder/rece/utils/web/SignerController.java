package com.minder.rece.utils.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.minder.rece.utils.certificate.SignatureManager;
import com.minder.rece.utils.pdf.RecePDF;
import com.minder.rece.utils.tools.Tools;

@Controller
public class SignerController {

	@ModelAttribute("model")
	public Map<String, Object> model() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", (new Date()).toString());
		myModel.put("util", "Signer");

		return myModel;
	}

	@RequestMapping(value = "/signer.htm", method = RequestMethod.GET)
	public ModelAndView handleSignerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			/*
			 * @param dn the X.509 Distinguished Name, eg
			 * "CN=Test, L=London, C=GB"
			 * 
			 * @param pair the KeyPair
			 * 
			 * @param days how many days from now the Certificate is valid for
			 * 
			 * @param algorithm the signing algorithm, eg "SHA1withRSA"
			 */
			 
			 //X509Certificate cert = SignatureManager.generateCertificate("CN=Test, L=London, C=GB", 90);
			 
			 
			/*
			 * String[] argss = {Decrypter.decrypt("[rtf_hzi"), "C:\\test.pfx"};
			 * ShowSignature.showSignatureFromPFX( argss );
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("signer");
	}

	@RequestMapping(value = "/uploadPDFFile.htm", method = RequestMethod.POST)
	ModelAndView uploadFileHandler(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("file") MultipartFile file) {

		Map<String, Object> document = new HashMap<String, Object>();
		
		// Upload fle
		String filePath = null;
		if (!file.isEmpty()) {
			try {

				filePath = Tools.uploadFile("tmp", name+"_"+request.getSession().getId(), "pdf", file.getBytes());

				document.put("name", name);
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + name + " because the file was empty.");
		}
		
		document.put("filepath", filePath);
		
		request.getSession().setAttribute("document", document);

		return new ModelAndView("signer");
	}

	@RequestMapping(value = "/documentAction.htm", method = RequestMethod.POST, params="showSignature")
	ModelAndView showSignatureHandler(HttpServletRequest request) {

		Map<String, Object> document = (Map<String, Object>) request.getSession().getAttribute("document");
		
		String filePath = document.get("filepath").toString();
		// Show signature
		String info = "";
		try {
			//"asd" is the key
			info = SignatureManager.getSignatureInfoFromFile("asd", new RecePDF(filePath));
		} catch (Exception e) {
			info = "Problem getting signature info.";

			System.out.println("Problem getting signature info from " + filePath);
			e.printStackTrace();
		}
		
		document.put("sigInfo", info.replace("\n", "<br/>"));

		return new ModelAndView("signer");
	}

	@RequestMapping(value = "/documentAction.htm", method = RequestMethod.POST, params="splitDocument")
	ModelAndView splitDocumentHandler(HttpServletRequest request, @RequestParam(required=false, value="dobleHoja") Boolean dobleHoja) {

		Map<String, Object> document = (Map<String, Object>) request.getSession().getAttribute("document");
		
		String filePath = document.get("filepath").toString();
		// Split document

		if(dobleHoja==null) dobleHoja=false;

		RecePDF doc = new RecePDF(filePath, dobleHoja);
		doc.splitDocument();
		doc.closeDocument();

		return new ModelAndView("signer");
	}
}
