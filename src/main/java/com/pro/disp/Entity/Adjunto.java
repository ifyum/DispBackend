package com.pro.disp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pro.disp.Entity.Enum.FileUploadStatus;
import com.pro.disp.Entity.Enum.TipoAdjunto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Adjunto.
 */

@Entity
@Table(name = "adjunto")
@Getter
@Setter
@NoArgsConstructor
public class Adjunto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_adjunto")
    private TipoAdjunto tipoAdjunto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creado")
    private LocalDate fechaCreado;

    @Column(name = "fecha_subido")
    private Instant fechaSubido;

    @Column(name = "archivo_nombre")
    private String archivoNombre;

    @Column(name = "archivo_mime_type")
    private String archivoMimeType;

    @Column(name = "archivo_size")
    private Long archivoSize;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private FileUploadStatus estado;

    @Lob
    @Column(name = "archivo")
    private byte[] archivo;

    @Column(name = "archivo_content_type")
    private String archivoContentType;

    @Column(name = "alfresco_node_id")
    private String alfrescoNodeId;

    @Column(name = "alfresco_node_path")
    private String alfrescoNodePath;

    @Column(name = "local_path")
    private String localPath;

    @Column(name = "jhi_hash")
    private String hash;

    @ManyToOne
    @JsonIgnoreProperties("adjuntos")
    private Providencia providencia;

    @ManyToOne
    @JsonIgnoreProperties("adjuntos")
    private MovimientoProvidencia movimientoProvidencia;

    @ManyToOne
    @JsonIgnore
    private Derivacion derivacion;

    @ManyToOne
    private Respuesta respuesta;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Adjunto adjunto = (Adjunto) o;
        if (adjunto.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), adjunto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Adjunto{" +
            "id=" + getId() +
            ", tipoAdjunto='" + getTipoAdjunto() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", fechaCreado='" + getFechaCreado() + "'" +
            ", fechaSubido='" + getFechaSubido() + "'" +
            ", archivoNombre='" + getArchivoNombre() + "'" +
            ", archivoMimeType='" + getArchivoMimeType() + "'" +
            ", archivoSize=" + getArchivoSize() +
            ", estado='" + getEstado() + "'" +
            ", archivo='" + getArchivo() + "'" +
            ", archivoContentType='" + getArchivoContentType() + "'" +
            ", alfrescoNodeId='" + getAlfrescoNodeId() + "'" +
            ", alfrescoNodePath='" + getAlfrescoNodePath() + "'" +
            ", localPath='" + getLocalPath() + "'" +
            ", hash='" + getHash() + "'" +
            "}";
    }
}
