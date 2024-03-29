package com.pro.disp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Grupo.
 */
@Entity
@Table(name = "grupo")
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Jhi_user> usuariosEnGrupo = new HashSet<>();

    @OneToMany(mappedBy = "derivadoAGrupo", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Derivacion> derivacion;

    @OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<NotificacionInBrowser> notificacionInBrowser;

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Set<User>  user;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Grupo() {
    }

//    public Set<User> getUser() {
//        return user;
//    }
//
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jhi_user> getUsuariosEnGrupo() {
        return usuariosEnGrupo;
    }

    public void setUsuariosEnGrupo(Set<Jhi_user> usuariosEnGrupo) {
        this.usuariosEnGrupo = usuariosEnGrupo;
    }

    public Set<Derivacion> getDerivacion() {
        return derivacion;
    }

    public void setDerivacion(Set<Derivacion> derivacion) {
        this.derivacion = derivacion;
    }

    public Set<NotificacionInBrowser> getNotificacionInBrowser() {
        return notificacionInBrowser;
    }

    public void setNotificacionInBrowser(Set<NotificacionInBrowser> notificacionInBrowser) {
        this.notificacionInBrowser = notificacionInBrowser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grupo grupo = (Grupo) o;

        return getId().equals(grupo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId());
    }

    @Override
    public String toString() {
        return "Grupo{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", usuariosEnGrupo=" + usuariosEnGrupo +
            '}';
    }
}
