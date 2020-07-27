package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class mostrarcitmodelo {
    private String nombremed,usuariomed,horacita,fechacita,usuariopa;
    public mostrarcitmodelo(){

    }
    public mostrarcitmodelo(String nombremed,String usuariomed,String horacita,String fechacita,String usuariopa){
        this.nombremed=nombremed;
        this.usuariomed=usuariomed;
        this.horacita=horacita;
        this.fechacita=fechacita;
        this.usuariopa=usuariopa;
    }
    public String getNombremed() {
        return nombremed;
    }

    public void setNombremed(String nombremed) {
        this.nombremed = nombremed;
    }

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getUsuariopa() {
        return usuariopa;
    }

    public void setUsuariopa(String usuariopa) {
        this.usuariopa = usuariopa;
    }
}
