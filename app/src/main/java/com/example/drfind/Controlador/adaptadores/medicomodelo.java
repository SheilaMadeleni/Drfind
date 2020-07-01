package com.example.drfind.Controlador.adaptadores;

public class medicomodelo {
    private String  especialidad, nombremedi, telefonomedi,usuariomed;
    public medicomodelo(){

    }
    public medicomodelo(String especialidad, String nombremedi,  String telefonomedi, String usuariomed){
        this.nombremedi=nombremedi;
        this.especialidad=especialidad;
        this.telefonomedi=telefonomedi;
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

    public String getUsuariomed() {
        return usuariomed;
    }

    public void setUsuariomed(String usuariomed) {
        this.usuariomed = usuariomed;
    }
}
