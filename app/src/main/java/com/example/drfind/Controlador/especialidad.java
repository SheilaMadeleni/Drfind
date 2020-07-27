package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.especimodelo;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class especialidad {
    public List<especimodelo>mostrar(String usuariopa){
    List<especimodelo> especi = new ArrayList<>();
        conexion db= new conexion();
        try {
            PreparedStatement st=db.conexionbd().prepareStatement("llamaespecialidad ?");
            st.setString(1,usuariopa);
            ResultSet rst=st.executeQuery();
            while (rst.next()){
                especi.add(new especimodelo(rst.getInt("idespecialidad"),rst.getString("nombreespecialidad"),rst.getString("usuariopac")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return especi;
    }
}
