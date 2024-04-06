package org.example;

import org.example.connection.conectiune;
import org.example.validPass.valid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class vanzator extends user{


    @Override
    public boolean creeazaCont(String inputEmail, String inputParola) {
        try {
            if (valid.validEmail(inputEmail)) {
                ResultSet r = conectiune.sql_get("SELECT *\n" +
                        "FROM vanzator\n" +
                        "WHERE email = '"+inputEmail+"';");
                if(r!=null && r.next())
                    if( r.getInt(1)>0)
                        return false;
                //data altcineva nu contine accelasi email ca si inputEmail
                //altfel return false
                if (valid.validParola(inputParola)) {
                    //adauga la baza de date o inregistrare noua
                    String s = "'" +inputEmail+"'"+","+"'"+valid.sha256(inputParola)+"'";
                    conectiune.sql_update("INSERT INTO vanzator (email, parola) VALUES ("+s+");");
                    return true;
                }

            }
        }catch(SQLException s){
            System.out.println("nu a mesrs");
            return false;
        }
        return false;
    }
}