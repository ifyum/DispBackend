package com.pro.disp.Entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by sneiraillanes on 24-04-2019.
 */
@Getter
@Setter
@Entity
@Table(name = "entidad")
public class Entidad implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entidad entidad = (Entidad) o;

        return getId() != null ? getId().equals(entidad.getId()) : entidad.getId() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId());
    }

    @Override
    public String toString() {
        return "Entidad{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            '}';
    }
}
