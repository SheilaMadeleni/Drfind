package com.example.drfind.Controlador.adaptadores.AdaptadoresPaciente;

public class especimodelo {
    private Integer idespeci;
    private String listespeci,usuariopa;

    public especimodelo() {

    }

    public especimodelo(Integer idespeci, String especialidad, String usuariopa) {
        this.idespeci=idespeci;
        this.listespeci = especialidad;
        this.usuariopa=usuariopa;
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

    public String getUsuariopa() {
        return usuariopa;
    }

    public void setUsuariopa(String usuariopa) {
        this.usuariopa = usuariopa;
    }
}

