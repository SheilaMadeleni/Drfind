package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.medicodetallemodelo;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.medicomodelo;
import com.example.drfind.modelo.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Medicos {
    public void agregarmedico(String usuamedico, String contramedico, String nombremedico, String apamedico,
                              String amamedico, String listespecialidad, String emailmedico, Integer colegiamed,
                              Integer telefomed, String fechanacimientomed){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("insert_medico ?,?,?,?,?,?,?,?,?,?");
            pst.setString(1,usuamedico);
            pst.setString(2,contramedico);
            pst.setString(3,nombremedico);
            pst.setString(4,apamedico);
            pst.setString(5,amamedico);
            pst.setString(6,listespecialidad);
            pst.setString(7,emailmedico);
            pst.setInt(8,colegiamed);
            pst.setInt(9,telefomed);
            pst.setString(10,fechanacimientomed);

            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }
    public void agregarhora(String usuamedico,String horas){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("insert_horario ?,?");
            pst.setString(1,usuamedico);
            pst.setString(2,horas);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void ratingbar(String usuariomed, float califica){
        conexion db=new  conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("ratingbar_valor ?,?");
            pst.setString(1,usuariomed);
            pst.setFloat(2,califica);
            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void eliminar(String usuariomed){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("elim_pac ?");
            pst.setString(1,usuariomed);
            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

        public List<medicomodelo> mostrarlistmedi(int idespeci){
        List<medicomodelo> medicos=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("lista_med ?");
            pst.setInt(1,idespeci);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                medicos.add(new medicomodelo(rst.getString("nombremedico"),rst.getString("nombreespecialidad"),
                        rst.getString("telefonomed"), rst.getString("usuariomed")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return medicos;
    }
    public List<medicodetallemodelo> mostrardetallemedi(String usuariomedico){
        List<medicodetallemodelo> medicos=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("lista_detallemed ?");
            pst.setString(1,usuariomedico);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                medicos.add(new medicodetallemodelo(rst.getString("nombremedico"),rst.getString("nombreespecialidad"),
                        rst.getString("telefonomed"),rst.getString("e_mailmed"),rst.getString("usuariomed")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return medicos;
    }

}


