package com.service;

import java.security.MessageDigest;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

public class TestGenerateString {
    public static void main(String[] args) {
        String password = "Abc123456";
        
        System.out.println("\nPassword: " + password);
        
        String salt = generateString(8);
        
        password += salt;
        
        String hashedPassword;
        
        System.out.println("\nSaltedPassword 8: " + password);
        
        System.out.println("Salt: " + salt);
        hashedPassword = getHash(password);
        System.out.println("\nHash Password: " + hashedPassword);
 
    }
     private static String characters = "";
     private static Random rng;
     public static String generateString(int length){
        // ASCII 48- 122    
        
        for (int i = 48; i <= 122; i++){  
           characters += (char) i; 
        }
        
        rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++){
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }
     
       public static String getHash(String password){
	String hasValue = "";
	String algorithm = "SHA-256";
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
