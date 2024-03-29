package com.pro.disp.repository;


import com.pro.disp.Entity.Plazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Plazo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlazoRepository extends JpaRepository<Plazo, Long> {

}
