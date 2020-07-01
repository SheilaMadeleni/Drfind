package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.especimodelo;
import com.example.drfind.modelo.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class especialidad {
    public List<especimodelo>mostrar(){
    List<especimodelo> especi = new ArrayList<>();
        conexion db= new conexion();
        try {
            Statement st=db.conexionbd().createStatement();
            ResultSet rst=st.executeQuery("llamaespecialidad");
            while (rst.next()){
                especi.add(new especimodelo(rst.getInt("idespecialidad"),rst.getString("nombreespecialidad")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return especi;
    }
}
