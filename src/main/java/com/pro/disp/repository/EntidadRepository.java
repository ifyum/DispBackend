package com.pro.disp.repository;


import com.pro.disp.Entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sneiraillanes on 24-04-2019.
 */

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long>
{

}
