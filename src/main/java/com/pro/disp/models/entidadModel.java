package com.pro.disp.models;

import com.pro.disp.Entity.Entidad;

import java.io.Serializable;

public class entidadModel implements Serializable {
    private Long id;
    private String nombre;

    // Constructor que toma una entidad como argumento
    public entidadModel(Entidad entidad) {
        this.id = entidad.getId();
        this.nombre = entidad.getNombre();
    }

}

