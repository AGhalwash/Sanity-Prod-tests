package stacks.utils.encriptacion;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class EncryptText {

    /**
     * @author gdosaigues
     * 01/06/2012
     * El tipo de encriptaci?n es AES CBC PKCS5Padding de 128 bits.
     */
    
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final String UTF8 = "UTF-8";
    private static final Logger logger = Logger.getLogger(EncryptText.class);
    
    EncryptText() {
    	// Emtpy constructor
    }
    
    public static String encrypt(String texto, String sharedKey)
    { 	
        String encoded = null;

        try {
        	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        	
        	byte[] ivData = sharedKey.substring(5, 21).getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(sharedKey.getBytes()), ALGORITHM);
            
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivData));
            byte[] encrypted = cipher.doFinal(texto.getBytes(UTF8) );

            encoded = new String(Base64.encodeBase64(encrypted, false), UTF8);
		} catch (NoSuchAlgorithmException|NoSuchPaddingException|InvalidKeyException|IllegalBlockSizeException|
				BadPaddingException|InvalidAlgorithmParameterException|UnsupportedEncodingException e) {
			logger.error(org.apache.commons.lang.exception.ExceptionUtils.getRootCauseMessage(e) + " ::" + texto);
		}


        return encoded;
    }

    public static String decrypt(String texto, String sharedKey)
    {
    	texto = texto.replace(' ','+');
        String decoded = null;

        try {
        	Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        	
        	byte[] ivData = sharedKey.substring(5, 21).getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(Base64.decodeBase64(sharedKey.getBytes()), ALGORITHM);
            
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(ivData));
            byte[] decrypted = cipher.doFinal(Base64.decodeBase64(texto.getBytes(UTF8)));

            decoded = new String(decrypted);
        } catch (NoSuchAlgorithmException|NoSuchPaddingException|InvalidKeyException|IllegalBlockSizeException|
				BadPaddingException|InvalidAlgorithmParameterException|UnsupportedEncodingException e) {
        	logger.error(org.apache.commons.lang.exception.ExceptionUtils.getRootCauseMessage(e));
        }
        
        return decoded;
    }
}