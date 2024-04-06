package org.example;

import org.example.connection.conectiune;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class user {
    private String email;
    private String parola;

    public boolean login(String inputEmail, String inputParola){
        try {
            boolean pass=false;
            ResultSet r = conectiune.sql_get("SELECT email,parola FROM vanzator WHERE email = '" + inputEmail + "';");
            if(r!=null)
                pass = r.getString("email").equals(inputParola);

            r = conectiune.sql_get("SELECT email,parola FROM cumparator WHERE email = '" + inputEmail + "';");
            if(r!=null)
                pass = r.getString("email").equals(inputParola);
        }catch(SQLException s){
            System.out.println(s);
        }
        return false;
    }

    public abstract boolean creeazaCont(String inputEmail, String inputParola);
}
