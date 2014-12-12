package signer;

public class Decrypter {
	
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
    
}
