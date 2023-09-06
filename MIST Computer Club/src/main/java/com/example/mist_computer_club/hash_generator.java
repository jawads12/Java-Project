package com.example.mist_computer_club;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hash_generator {
    public static String getHash(String hash,String algorithm){
        String hashval = "";
        byte[] inputBytes = hash.getBytes();
        try {
            MessageDigest Messagedigest = MessageDigest.getInstance(algorithm);
            Messagedigest.update(inputBytes);
            byte[] digestedbytes = Messagedigest.digest();
            BigInteger number = new BigInteger(1, digestedbytes);

            // Convert message digest into hex value
            StringBuilder hexString = new StringBuilder(number.toString(16));

            // Pad with leading zeros
            while (hexString.length() < 64)
            {
                hexString.insert(0, '0');
            }
            hashval = hexString.toString();


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hashval;
    }



}
//calling
//hash_generator.getHash(hash, "SHA-256")