package com.minder.rece.utils.signer;

public class Encrypter {
	
	static int[] algorithm = {-7, 9, 2, 2, -3, -1, 8, 5, -4, -3, -2, 4, 3, 2, 1, -1};
    
    public static String decrypt(String encryptedPassword){
    	
    	String decryptedPassword = "";
    	int i=0;
    	while(i<encryptedPassword.length() && i<algorithm.length){
    		decryptedPassword+=(char)(encryptedPassword.charAt(i)-algorithm[i]);
    		++i;
    	}

    	return decryptedPassword;
    }
    
    public static String encrypt(String decryptedPassword){
    	
    	String encryptedPassword = "";
    	int i=0;
    	while(i<encryptedPassword.length() && i<algorithm.length){
    		encryptedPassword+=(char)(decryptedPassword.charAt(i)+algorithm[i]);
    		++i;
    	}

    	return encryptedPassword;
    }
    
}
