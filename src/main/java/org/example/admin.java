package org.example;

public class admin extends user {

    @Override
    public boolean login(String inputEmail, String inputParola) {
        if(inputEmail.equals("admin@admin.com")){
            return inputParola.equals("admin");
        }
        return false;
    }

    @Override
    public boolean creeazaCont(String inputEmail, String inputParola) {
        return false;
    }



}
