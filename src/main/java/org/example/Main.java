package org.example;





import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/proiect";
        Connection connection = (Connection) DriverManager.getConnection (url, "Andrei", "proiect");

        Statement statement;
        statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("select * from produs");
        while(rs.next()){
            System.out.println("id="+rs.getInt("pid")+", nume= " + rs.getString("nume")+ ", vid="+rs.getInt("vid")+", pret="+rs.getDouble("pret"));
        }


    }
}