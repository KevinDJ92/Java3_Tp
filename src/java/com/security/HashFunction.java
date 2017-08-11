package com.security;

import java.security.MessageDigest;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

public class HashFunction {
    	
    // Available algorithms are: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512	
    public static String getHash(String password, String algorithm){
	String hasValue = "";
	algorithm = "SHA-256";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(password.getBytes());
            byte[] disgestedBytes = messageDigest.digest();
            hasValue = DatatypeConverter.printHexBinary(disgestedBytes).toLowerCase();
            
        }catch(Exception e){
            
        }
	return hasValue;
    }
    
    public static String generateString(Random rng, String characters, int length){
    // ASCII 48- 90    
   
    for (int i = 48; i <= 90; i++){  
       characters += String.valueOf(i); 
    }

        
    char[] text = new char[length];
    for (int i = 0; i < length; i++){
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}
    
}
