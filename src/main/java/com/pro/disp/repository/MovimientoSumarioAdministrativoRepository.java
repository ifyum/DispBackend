package com.pro.disp.repository;


import com.pro.disp.Entity.MovimientoSumarioAdministrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the MovimientoSumarioAdministrativo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MovimientoSumarioAdministrativoRepository extends JpaRepository<MovimientoSumarioAdministrativo, Long> {

}
