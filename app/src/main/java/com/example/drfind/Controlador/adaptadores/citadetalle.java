package com.example.drfind.Controlador.adaptadores;

public class citadetalle {
    String nombremedi, especialidad,fechacita,horacita;
    public  citadetalle(){
    }
    public citadetalle(String nombremedi,String especialidad, String fechacita, String horacita){
        this.nombremedi=nombremedi;
        this.especialidad=especialidad;
        this.fechacita=fechacita;
        this.horacita=horacita;
    }

    public String getNombremedi() {
        return nombremedi;
    }

    public void setNombremedi(String nombremedi) {
        this.nombremedi = nombremedi;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }
}
