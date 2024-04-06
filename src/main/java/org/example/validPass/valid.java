package org.example.validPass;

import java.security.MessageDigest;

public class valid {
    public static boolean validEmail(String email){
        if(!email.contains("@"))return false;
        if(!email.contains("."))return false;
        if(!have(email,"q w e r t y u i o p l k j h g f d s a z x c v b n m"))return false;
        return email.length() >= 7;
    }
    public static boolean validParola(String parola){
        if(!have(parola,"1 2 3 4 5 6 7 8 9 0"))return false;
        if(!have(parola,"Q W E R T Y U I O P L K J H G F D S A Z X C V B N M"))return false;
        return parola.length()>=8;
    }

    private static boolean have(String str,String setStr){
        String[] set=setStr.split(" ");
        for (String s : set) {
            if (!str.contains(s)) continue;
            return true;
        }
        return false;
    }

    public static String sha256(final String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
