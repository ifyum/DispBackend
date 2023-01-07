package com.pro.disp.repository;


import com.pro.disp.Entity.Plantilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Plantilla entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlantillaRepository extends JpaRepository<Plantilla, Long> {

}

