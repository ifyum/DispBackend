package com.pro.disp.repository;


import com.pro.disp.Entity.SumarioAdministrativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SumarioAdministrativo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SumarioAdministrativoRepository extends JpaRepository<SumarioAdministrativo, Long> {

}
