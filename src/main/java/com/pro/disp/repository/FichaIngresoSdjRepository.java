package com.pro.disp.repository;


import com.pro.disp.Entity.FichaIngresoSdj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FichaIngresoSdj entity.
 */
//@SuppressWarnings("unused")
@Repository
public interface FichaIngresoSdjRepository extends JpaRepository<FichaIngresoSdj, Long> {

}
