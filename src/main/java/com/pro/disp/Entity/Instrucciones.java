//package com.pro.disp.Entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//@Getter
//@Setter
//@Entity
//@Table(name = "instrucciones")
//public class Instrucciones implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "nombre")
//    private String nombre;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Instrucciones that = (Instrucciones) o;
//        return getId().equals(that.getId()) &&
//            getNombre().equals(that.getNombre());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getNombre());
//    }
//
//    @Override
//    public String toString() {
//        return "Instrucciones{" +
//            "id=" + id +
//            ", nombre='" + nombre + '\'' +
//            '}';
//    }
//}
