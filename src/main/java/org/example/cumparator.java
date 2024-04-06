package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.validPass.valid;

import org.example.connection.conectiune;
public class cumparator extends user {

    @Override
    public boolean login(String inputEmail,String inputParola) {
        try {
            if (valid.validEmail(inputEmail)) {
                ResultSet r = conectiune.sql_get("SELECT EMAIL,PAROLA FROM CUMPARATOR WHERE EMAIL='" + inputEmail + "';");
                if (r != null && r.next()) {
                    if (r.getString("email").equals(inputEmail)) {
                        if(r.getString("parola").equals(valid.sha256(inputParola)))
                            return true;
                    }
                }
            }
        }catch(SQLException s){
            System.out.println(s);

            return false;
        }
        return false;
    }

    @Override
    public boolean creeazaCont(String inputEmail, String inputParola) {
        try {
            if (valid.validEmail(inputEmail)) {
                ResultSet r = conectiune.sql_get("SELECT *\n" +
                        "FROM cumparator\n" +
                        "WHERE email = '"+inputEmail+"';");
                if(r!=null && r.next())
                    if( r.getInt(1)>0)
                        return false;
                //data altcineva nu contine accelasi email ca si inputEmail
                //altfel return false
                if (valid.validParola(inputParola)) {
                    //adauga la baza de date o inregistrare noua
                    String s = "'" +inputEmail+"'"+","+"'"+valid.sha256(inputParola)+"'";
                    conectiune.sql_update("INSERT INTO cumparator (email, parola) VALUES ("+s+");");
                    return true;
                }
            }
        }catch(SQLException s){
            System.out.println("nu a mesrs");
            return false;
        }
        return false;
    }

    public boolean cumparaProdus(){
        return false;
    }

    public boolean faceOferta(){
        return false;
    }

    public boolean viziualizareListaProduse(){
        return false;
    }
}
