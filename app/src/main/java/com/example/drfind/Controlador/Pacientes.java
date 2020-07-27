package com.example.drfind.Controlador;

import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.mostrarcitmodelo;
import com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente.sacarcitamodelo;
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
    public void agregarcita(Integer id,String fechitacita, String hora,String usuariomed){
        conexion db=new conexion();
                try{
                    PreparedStatement pst=db.conexionbd().prepareStatement("ins_citapac ?,?,?,?");
                    pst.setInt(1,id);
                    pst.setString(2,fechitacita);
                    pst.setString(3,hora);
                    pst.setString(4,usuariomed);
                    pst.executeUpdate();
                } catch (SQLException e) {
                    e.getMessage();
                }
    }
    public List<sacarcitamodelo>sacarcitamodeloList(String usuariomed,String fechacita){
        List<sacarcitamodelo> citapac=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("ins_horitia ?,?");
            pst.setString(2,usuariomed);
            pst.setString(1,fechacita);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                citapac.add(new sacarcitamodelo(rst.getString("usuariomed"),rst.getString("horas"),rst.getString("fechacita"),rst.getString("id")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return citapac;
    }
    public List<mostrarcitmodelo>mostrarcitmodeloList(String usuariopac){
        List<mostrarcitmodelo> listci=new ArrayList<>();
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("list_citas_paciente ?");
            pst.setString(1,usuariopac);
            ResultSet rst=pst.executeQuery();
            while (rst.next()){
                listci.add(new mostrarcitmodelo(rst.getString("nombremedico"),rst.getString("usuariomed"),rst.getString("horacita"),rst.getString("fechacita"),rst.getString("usuariopac")));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return listci;
    }

    public void eliminarcitapac (String usuariomed, String fechacita, String horacita, String usuariopac){
        conexion db=new conexion();
        try {
            PreparedStatement pst=db.conexionbd().prepareStatement("elim_cit ?,?,?,?");
            pst.setString(1,usuariomed);
            pst.setString(2,fechacita);
            pst.setString(3,horacita);
            pst.setString(4,usuariopac);
            pst.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }
}
