package com.minder.rece.utils.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignerController {

	
	@RequestMapping(value="/signer.htm")
    public ModelAndView handleSignerRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("util", "Signer");
        
	    try {
	        
	
	        /*
			 * @param dn the X.509 Distinguished Name, eg "CN=Test, L=London, C=GB"
			 * @param pair the KeyPair
			 * @param days how many days from now the Certificate is valid for
			 * @param algorithm the signing algorithm, eg "SHA1withRSA"
			 */ 
	/*
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048);
	
			X509Certificate cert = CreateCertificate.generateCertificate("CN=Test, L=London, C=GB", kpg.genKeyPair(), 90, "SHA1withRSA");
			
			System.out.println(cert);
			*/
			/*
	        String[] argss = {Decrypter.decrypt("[rtf_hzi"), "C:\\test.pfx"};
	        ShowSignature.showSignatureFromPFX( argss );
	        */
	        //String[] argss2 = {"asd", "C:\\test.pdf"};
			//ShowSignature.showSignature(argss2);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return new ModelAndView("home", "model", myModel);
    }
}
