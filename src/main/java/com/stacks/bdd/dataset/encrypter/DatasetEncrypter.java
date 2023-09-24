package com.stacks.bdd.dataset.encrypter;

import stacks.utils.encriptacion.EncryptText;

/**
 * Encapsulate the encryption and decryption functionality.
 * 
 * @author ttrigo
 *
 */
public class DatasetEncrypter {

	/**
	 * select distinct(valor) from stk_configuraciones where SECCION='SEGURIDAD' and CAMPO ='CLAVE_ENCRIPTACION_ONECONSENT';
	 */
	private static final String SHARED_KEY = "LPnkeLcOZr/ualCqBk8WTg==";
	
	/**
	 * Encapsulate encrypt method.
	 * 
	 * @see EncryptText.
	 * @see URLEncoder.
	 * @param text to be encrypted.
	 * @return the text encrypted.
	 */
	public String encrypt(String text) {
		return EncryptText.encrypt(text, SHARED_KEY);
	}	
	
	/**
	 * Encapsulate decrypt method.
	 * 
	 * @see EncryptText.
	 * @param text to be decrypted.
	 * @return the text decrypted.
	 */
	public String decrypt(String text) {
		return EncryptText.decrypt(text, SHARED_KEY);
	}

	/**
	 * Encapsulate decrypt method, also parse the result to Integer.
	 * 
	 * @see EncryptText.
	 * @param text to be decrypted.
	 * @return the text decrypted as Integer.
	 */
	public int decryptInteger(String text) {
		return Integer.parseInt(EncryptText.decrypt(text, SHARED_KEY));
	}	
	
}
