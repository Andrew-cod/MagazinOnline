package org.example;

import org.example.connection.conectiune;
import org.example.validPass.valid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class admin extends user {

    @Override
    public boolean login(String inputEmail, String inputParola) {
        if(inputEmail.equals("admin@admin.com")){
            return inputParola.equals("admin");
        }
        return false;
    }

    public boolean adaugaVanzatori(String inputEmail,String inputParola){
        //sigur
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

    public boolean verificaVanzator(String email){
        //sigur
        return conectiune.sql_update("UPDATE vanzator SET verif = 1 WHERE email = '"+email+"';\n");
    }

    public boolean anulareContVanzator(String email){
        return conectiune.sql_update("UPDATE vanzator SET verif = 0 WHERE email = '"+email+"';\n");
    }

    public boolean listVanzator(){
        //--nustiu ce tip de date sa folosesc si cum sa returnez
        return false;
    }

    @Override
    public boolean creeazaCont(String inputEmail, String inputParola) {
        return false;
    }
}
