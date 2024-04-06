package org.example.connection;

import java.sql.*;

public class conectiune {
        public static Connection connect;
        public static ResultSet sql_get(String sqlStatement){
            try {
                if (connect == null) {
                    connect = connect();
                }
                Statement statement;
                statement = connect.createStatement();
                return statement.executeQuery(sqlStatement);
            }
            catch(SQLException s){
                System.out.println(s);
            }
            return null;
        }

    public static boolean sql_update(String sqlStatement){
        try {
            if (connect == null) {
                connect = connect();
            }
            Statement statement;
            statement = connect.createStatement();
            return statement.executeUpdate(sqlStatement)!=0;
        }
        catch(SQLException s){
            System.out.println(s);
        }
        return false;
    }

        private static Connection connect() throws SQLException {

            String url = "jdbc:mysql://localhost:3306/proiect";
            return (Connection) DriverManager.getConnection (url, "Andrei", "proiect");
        }

        public Connection getConnect(){
            return connect;
        }
}

