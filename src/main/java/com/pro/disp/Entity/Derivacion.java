package com.pro.disp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.pro.disp.Entity.Enum.EstadoDerivacion;
import com.pro.disp.Entity.Enum.TipoDerivacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Derivacion.
 */
@Entity
@Table(name = "derivacion")
@Getter
@Setter
@NoArgsConstructor
public class Derivacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_derivacion")
    private Instant fechaDerivacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoDerivacion estado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoDerivacion tipo;

    @OneToMany(mappedBy = "derivacion")
    private Set<Documento> documentos = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("derivaciones")
    private Providencia providencia;

    @ManyToOne
    @JoinColumn(name = "jhi_user_id")
    private User derivadoAUsuario;

    @ManyToOne
    private User derivadoPorUsuario;

    @ManyToOne(targetEntity = Grupo.class)
    private Grupo derivadoAGrupo;

    @ManyToOne(targetEntity = Grupo.class)
    private Grupo derivadoPorGrupo;

    @OneToMany(mappedBy = "derivacion")
    private Set<Adjunto> adjuntos;

    //todo: revisar si se necesita las copias de grupo en la derivacion
//    @ManyToOne
//    @JoinColumn(name = "grupo_id")
//    private Set<Grupo> gruposACopiar;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Derivacion derivacion = (Derivacion) o;
        if (derivacion.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), derivacion.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Derivacion{" +
            "id=" + id +
            ", observacion='" + observacion + '\'' +
            ", fechaDerivacion=" + fechaDerivacion +
            ", estado=" + estado +
            ", tipo=" + tipo +
            ", documentos=" + documentos +
            ", providencia=" + providencia +
            ", derivadoAUsuario=" + derivadoAUsuario +
            ", derivadoPorUsuario=" + derivadoPorUsuario +
            ", derivadoAGrupo=" + derivadoAGrupo +
            ", derivadoPorGrupo=" + derivadoPorGrupo +
            '}';
    }

}
