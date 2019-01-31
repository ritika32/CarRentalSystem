package com.carreservationsystemCRD.app;

import java.sql.*;

public class GetSqliteConn {

    public static Connection getConnection(){
        try {
            String database = "carrentalsystem";
            String dbURL = "jdbc:sqlite:"+database+".db";
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                return  conn;
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
