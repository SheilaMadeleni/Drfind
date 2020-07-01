package com.example.drfind.Controlador.adaptadores;

public class especimodelo {
    private Integer idespeci;
    private String listespeci;

    public especimodelo() {

    }

    public especimodelo(Integer idespeci, String especialidad) {
        this.idespeci=idespeci;
        this.listespeci = especialidad;
    }

    public Integer getIdespeci() {
        return idespeci;
    }

    public void setIdespeci(Integer idespeci) {
        this.idespeci = idespeci;
    }

    public String getListespeci() {
        return listespeci;
    }

    public void setListespeci(String listespeci) {
        this.listespeci = listespeci;
    }
}

