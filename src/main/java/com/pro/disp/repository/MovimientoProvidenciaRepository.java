package com.pro.disp.repository;


import com.pro.disp.Entity.MovimientoProvidencia;
import com.pro.disp.Entity.Providencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


/**
 * Spring Data  repository for the MovimientoProvidencia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MovimientoProvidenciaRepository extends JpaRepository<MovimientoProvidencia, Long>
{
    @Query("SELECT m FROM MovimientoProvidencia m INNER JOIN m.providencia p WHERE p = :providencia " +
        "ORDER BY m.fecha asc")
    Set<MovimientoProvidencia> findByProvidencia(@Param("providencia") Providencia providencia);

//    @Query("SELECT m FROM MovimientoProvidencia m INNER JOIN m.providencia p WHERE p = :providencia " +
//        "ORDER BY m.fecha desc")
//    List<MovimientoProvidencia> findByProvidencia(@Param("providencia") Providencia providencia);

    // Set<MovimientoProvidencia> findByProvidenciaOrderByProvidenciaDesc(Providencia providencia);



//    @Query("SELECT M FROM MovimientoProvidencia m where m.providencia=:Id" )
//        List<MovimientoProvidencia> traerMovimientos(@Param("Id") Long Id);


//    @Query(value = "SELECT * FROM movimiento_providencia m where m.providencia_id =:id  order by m.fecha desc limit 1", nativeQuery = true)
//    MovimientoProvidencia traerMovimientos(@Param("id") Long id);

    @Query(value = "SELECT * FROM movimiento_providencia m where m.providencia_id =:id  order by m.fecha desc limit 1", nativeQuery = true)
    MovimientoProvidencia traerMovimientos(@Param("id") Long id);

    @Query(value = "SELECT m.numero_dgdp FROM movimiento_providencia m where m.providencia_id = :id order by m.fecha desc limit 1", nativeQuery = true)
    Long findNumeroDGDPMasRecienteByProvidenciaId(@Param("id") Long id);


    @Query(value = "SELECT * FROM movimiento_providencia m where m.providencia_id =:id  order by m.fecha desc limit 1", nativeQuery = true)
    MovimientoProvidencia traerUltimoMovimientos(@Param("id") Long id);



}
