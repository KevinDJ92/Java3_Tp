package com.security;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class HashFunction {
    private static String algorithm = "";
    
    public HashFunction(){
    
    }
    
    // Available algorithms are: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512	
    public String getHash(String password){
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
}
