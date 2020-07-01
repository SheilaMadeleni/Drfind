package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.citadetalle;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pacientes {

    public void agregarpaciente(String usuapaciente, String contrapaciente, String nombrepaciente, String apapaciente,
                                String amapaciente, String direccionpaciente, String emailpaciente, Integer telefopaciente,
                                String fechanacimientopaciente){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("insert_paciente ?,?,?,?,?,?,?,?,?");
            pst.setString(1,usuapaciente);
            pst.setString(2,contrapaciente);
            pst.setString(3,nombrepaciente);
            pst.setString(4,apapaciente);
            pst.setString(5,amapaciente);
            pst.setString(6,direccionpaciente);
            pst.setString(7,emailpaciente);
            pst.setInt(8,telefopaciente);
            pst.setString(9,fechanacimientopaciente);

            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void agregarcita(String fechitacita, String horitacita){
        conexion db=new conexion();
                try{
                    PreparedStatement pst=db.conexionbd().prepareStatement("insert_fecha ?,?");
                    pst.setString(1,fechitacita);
                    pst.setString(2,horitacita);
                    pst.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }
    public List<citadetalle> mostrarlistcita(String nombreusume) {
        List<citadetalle> citas = new ArrayList<>();
        conexion db = new conexion();
        try {
            PreparedStatement pst = db.conexionbd().prepareStatement("list_citapaciente ?");
            pst.setString(1,nombreusume);
        ResultSet rst=pst.executeQuery();
            while (rst.next()){
                citas.add(new citadetalle(rst.getString("nombremedico"),rst.getString("nombreespecialidad"),
                        rst.getString("fechacita"), rst.getString("horacita")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

}
