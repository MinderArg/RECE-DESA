package signer;


import java.security.KeyPairGenerator;
import java.security.cert.X509Certificate;

public class Main {

	public static void main(String[] args) throws Exception {
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
        String[] argss2 = {"asd", "C:\\test.pdf"};
        ShowSignature.showSignature(argss2 );
		 
	}

}
