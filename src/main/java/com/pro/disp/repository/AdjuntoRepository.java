package com.pro.disp.repository;


import com.pro.disp.Entity.Adjunto;
import com.pro.disp.Entity.Enum.FileUploadStatus;
import com.pro.disp.Entity.MovimientoProvidencia;
import com.pro.disp.Entity.Providencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Spring Data  repository for the Adjunto entity.
 */

@Repository
public interface AdjuntoRepository extends JpaRepository<Adjunto, Long> {

    Adjunto findByHash(String hash);

    Adjunto findAdjuntoById(Long id);

    List<Adjunto> findByProvidencia(Providencia providencia);

    @Modifying
    @Transactional
    @Query("update Adjunto set providencia.id = :providencia, estado = :status where hash in (:hashes)")
    void confirmarComoIngresoProvidencia(@Param("providencia") Long providencia, @Param("status") FileUploadStatus status, @Param("hashes")ArrayList<String> hashes);

    @Modifying
    @Transactional
    @Query("update Adjunto set localPath = :newPath where hash = :hash")
    void actualizarFilePath(@Param("hash") String hash, @Param("newPath") String localPath);

    @Modifying
    @Transactional
    @Query("UPDATE Adjunto SET movimientoProvidencia = :movProv, providencia = :prov WHERE id = :idAdjunto")
    void updateMovimiento(@Param("movProv") MovimientoProvidencia movProv, @Param("prov") Providencia prov, @Param("idAdjunto") Long idAdjunto);

    @Query(" select count(a.providencia) from Adjunto a where a.providencia.id = :id")
    Integer Contar(@Param("id") Long id);

}


