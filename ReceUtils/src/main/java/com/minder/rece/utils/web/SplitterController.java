package com.minder.rece.utils.web;

import java.io.File;
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

import com.minder.rece.utils.certificate.Encrypter;
import com.minder.rece.utils.pdf.RecePDF;
import com.minder.rece.utils.tools.Tools;

@Controller
public class SplitterController {

	@ModelAttribute("model")
	public Map<String, Object> model() {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", (new Date()).toString());
		myModel.put("util", "Signer");

		return myModel;
	}

	@RequestMapping(value = "/splitter.htm", method = RequestMethod.GET)
	public ModelAndView handleSignerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return new ModelAndView("splitter");
	}

	@RequestMapping(value = "/uploadPDFtoSplit.htm", method = RequestMethod.POST)
	ModelAndView uploadFileHandler(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		Map<String, Object> document = new HashMap<String, Object>();

		// Upload fle
		String filePath = null;
		if (!file.isEmpty()) {
			try {

				filePath = Tools.uploadFile("tmp" + File.separator + "tmpFiles", name + "_"
						+ request.getSession().getId(), "pdf", file.getBytes());

				document.put("name", name);
			} catch (Exception e) {
				System.out.println("You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + name + " because the file was empty.");
		}

		document.put("filepath", filePath);

		request.getSession().setAttribute("document", document);

		return new ModelAndView("splitter");
	}

	@RequestMapping(value = "/splitDocument.htm", method = RequestMethod.POST)
	ModelAndView splitDocumentHandler(HttpServletRequest request,
			@RequestParam(required = false, value = "dobleHoja") Boolean dobleHoja) {

		Map<String, Object> document = (Map<String, Object>) request.getSession().getAttribute("document");

		String filePath = document.get("filepath").toString();
		// Split document

		if (dobleHoja == null)
			dobleHoja = false;

		RecePDF doc = new RecePDF(filePath, dobleHoja);
		doc.splitDocument();
		doc.closeDocument();

		return new ModelAndView("splitter");
	}
}
