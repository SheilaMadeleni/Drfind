package com.example.drfind.modelo;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    public Connection conexionbd(){
        Connection connection=null;
        try {
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.2;databaseName=appmedicina;user=sa;password=123;");
        } catch (Exception e){
           e.getMessage();
        }
        return connection;
    }
}
