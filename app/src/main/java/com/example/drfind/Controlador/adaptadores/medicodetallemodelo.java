package com.example.drfind.Controlador.adaptadores;

public class medicodetallemodelo {
    private String  especialidad, nombremedi, telefonomedi,e_mailmed,usuariomed;
    public medicodetallemodelo(){

    }
    public medicodetallemodelo(String especialidad, String nombremedi,  String telefonomedi, String e_mailmed, String usuariomed){
        this.nombremedi=nombremedi;
        this.especialidad=especialidad;
        this.telefonomedi=telefonomedi;
        this.e_mailmed=e_mailmed;
        this.usuariomed=usuariomed;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombremedi() {
        return nombremedi;
    }

    public void setNombremedi(String nombremedi) {
        this.nombremedi = nombremedi;
    }

    public String getTelefonomedi() {
        return telefonomedi;
    }

    public void setTelefonomedi(String telefonomedi) {
        this.telefonomedi = telefonomedi;
    }

    public String getE_mailmed() {
        return e_mailmed;
    }

    public void setE_mailmed(String e_mailmed) {
        this.e_mailmed = e_mailmed;
    }

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }
}
