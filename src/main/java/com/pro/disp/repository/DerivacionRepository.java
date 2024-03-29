package com.pro.disp.repository;


import com.pro.disp.Entity.Derivacion;
import com.pro.disp.Entity.Providencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Derivacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DerivacionRepository extends JpaRepository<Derivacion, Long> {

//    @Query("select d from Derivacion d inner join d.providencia s where s = :providencia and (" +
//        "d.estado <> 'CREADA' or d.estado is null) order by d.fechaDerivacion desc")
//    List<Derivacion> findLastPorProvidencia(@Param("providencia") Providencia providencia);

    @Query("select d from Derivacion d inner join d.providencia s where s = :providencia order by d.fechaDerivacion desc")
    List<Derivacion> findLastByProvidencia(@Param("providencia") Providencia providencia);
}
