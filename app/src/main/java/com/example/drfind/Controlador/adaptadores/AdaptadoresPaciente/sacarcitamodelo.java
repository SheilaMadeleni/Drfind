package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class sacarcitamodelo {
    String usuarioname,horacita,fechacita,id;
    public sacarcitamodelo(){
    }
    public sacarcitamodelo(String usuarioname,String horacita,String fechacita,String id){
        this.horacita=horacita;
        this.usuarioname=usuarioname;
        this.fechacita=fechacita;
        this.id=id;
    }

    public String getUsuarioname() {
        return usuarioname;
    }

    public void setUsuarioname(String usuarioname) {
        this.usuarioname = usuarioname;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
