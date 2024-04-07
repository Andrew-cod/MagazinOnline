package org.example;

public abstract class user {
    private String email;
    private String parola;
    public abstract boolean login(String inputEmail, String inputParola);
    public abstract boolean creeazaCont(String inputEmail, String inputParola);
}
