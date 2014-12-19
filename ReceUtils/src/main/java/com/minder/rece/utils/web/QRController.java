package com.minder.rece.utils.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pdfbox.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.minder.rece.utils.qrgen.MECard;
import com.minder.rece.utils.qrgen.QRGenerator;
import com.minder.rece.utils.tools.Tools;


@Controller
public class QRController {
	
	private String defaultFilename = "tmp\\QR_Code";
	private String fileExt = "png";
	
	private String getFilename(HttpSession s){
		return defaultFilename+s.getId()+"."+fileExt;
	}
	
	@RequestMapping(value="/qrgen.htm", method=RequestMethod.GET)
    public ModelAndView handleGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
    	String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("util", "QRGenerator");
        myModel.put("showQR", false);

        ModelAndView model = new ModelAndView("qrgen");
        model.addObject("model", myModel);
        model.addObject("command", new MECard());
        return model;
    }
	
	@RequestMapping(value="/qrgen.htm", method=RequestMethod.POST)
    public ModelAndView handlePostRequest(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("command")
	MECard meCard)
            throws ServletException, IOException {

		
    	String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("util", "QRGenerator");
        myModel.put("showQR", true);
        
        String filename = getFilename(request.getSession());
	    try {
	    	File dir = new File("tmp");
	    	dir.mkdir();

	    	QRGenerator.generateMECardQRCode(filename, meCard);
	    	
	    	//Tools.deleteFile(dir);
				
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch3");
		}


        ModelAndView model = new ModelAndView("qrgen");
        model.addObject("model", myModel);
        model.addObject("command", meCard);
	    
        return model;
    }
	
	@RequestMapping(value = "/qr")
	public void getQRImage(HttpServletResponse response, HttpServletRequest request) throws IOException {

        String filename = getFilename(request.getSession());
        
	    File img = new File(filename);
	    boolean isHotlink = !img.exists();
	    if(isHotlink){
	    	img = new File("NoHotlinking.png");
	    }

	    response.setContentType("image/png");
	    InputStream in =  new FileInputStream(img);
	    
	    IOUtils.copy(in, response.getOutputStream());
	    in.close();
	    
	    if(!isHotlink)Tools.deleteFile(img);
	}

}
