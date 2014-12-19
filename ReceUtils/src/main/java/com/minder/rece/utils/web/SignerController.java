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

import com.minder.rece.utils.signer.SignatureManager;
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
	
	@RequestMapping(value="/signer.htm", method = RequestMethod.GET)
    public ModelAndView handleSignerRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
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
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
        return new ModelAndView("signer");
    }
	
	@RequestMapping(value = "/uploadPDFFile", method = RequestMethod.POST)
    ModelAndView uploadFileHandler(@RequestParam("name") String name,
    							   @RequestParam("file") MultipartFile file) {
		
		//Upload fle
		String filePath = null;
        if (!file.isEmpty()) {
            try {
                
            	filePath = Tools.uploadFile(name, "pdf", file.getBytes());
 
                System.out.println("You successfully uploaded file=" + name);
            } catch (Exception e) {
            	System.out.println("You failed to upload " + name + " => " + e.getMessage());
            }
        } else {
        	System.out.println("You failed to upload " + name + " because the file was empty.");
        }
        //Show signature
        String info = "";
        try {
			info = SignatureManager.getSignatureInfoFromFile("asd", filePath);
		} catch (Exception e) {
			info = "Problem getting signature info.";
			
			System.out.println("Problem getting signature info from "+filePath);
			e.printStackTrace();
		}
        
        return new ModelAndView("signer", "sigInfo", info.replace("\n", "<br/>"));
    }
}
