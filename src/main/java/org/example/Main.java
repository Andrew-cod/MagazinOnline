package org.example;
import java.sql.Connection;
import java.sql.ResultSet; import java.sql.SQLException;
import org.example.connection.conectiune;
public class Main {
    public static void main(String[] args) throws SQLException {
        cumparator x = new cumparator();
        vanzator v=new vanzator();
        admin a = new admin();

        System.out.println(v.creeazaCont("eu@upt.ro","jal76578Aoalo"));
        ResultSet r = conectiune.sql_get("SELECT * FROM vanzator");
        while(r.next()){
            System.out.println(r.getString("verif"));
        }
        System.out.println(v.login("eu@upt.ro","jal76578Aoalo"));

    }
}