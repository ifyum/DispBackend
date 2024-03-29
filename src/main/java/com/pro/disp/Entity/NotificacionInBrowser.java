/*
 *
 * este codigo cuenta con la participacion de Rubén Hernan Barrera Chavez
 *
 */

package com.pro.disp.Entity;



import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A NotificacionInBrowser.
 */
@Entity
@Table(name = "notificacion_in_browser")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NotificacionInBrowser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    //creado por ruben
    @Column(name = "contenido")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Jhi_user jhiuser;

    //creado por ruben
    @ManyToOne(targetEntity = Grupo.class)
    private Grupo grupo;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "visto")
    private Boolean visto;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Jhi_user getUser() {
        return jhiuser;
    }

    public void setUser(Jhi_user jhiuser) {
        this.jhiuser = jhiuser;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotificacionInBrowser notificacionInBrowser = (NotificacionInBrowser) o;
        if (notificacionInBrowser.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), notificacionInBrowser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NotificacionInBrowser{" +
            "id=" + id +
            ", contenido='" + contenido + '\'' +
            ", userid=" + jhiuser +
            ", grupo=" + grupo +
            ", createdAt=" + createdAt +
            ", visto=" + visto +
            '}';
    }



}
