package com.pro.disp.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.pro.disp.Entity.Entidad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
public class EntidadRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EntidadRepository entidadRepository;
    @Test
    public void testFindById() {
        // Arrange
        Entidad entidad = new Entidad();
        entidad.setNombre("Prueba");
        entidad = entityManager.persist(entidad);
        entityManager.flush();

        // Act
        Optional<Entidad> result = entidadRepository.findById(entidad.getId());

        // Assert
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getNombre()).isEqualTo("Prueba");
    }
    @Test
    public void testFindAll() {
        // Arrange
        Entidad entidad = new Entidad();
        entidad.setNombre("Prueba");
        entidad = entityManager.persist(entidad);
        entityManager.flush();

        // Act
        List<Entidad> result = entidadRepository.findAll();

        // Assert
        assertThat(result.size()).isGreaterThan(0);
    }
    @Test
    public void testSave() {
        // Arrange
        Entidad entidad = new Entidad();
        entidad.setNombre("Prueba");

        // Act
        Entidad result = entidadRepository.save(entidad);

        // Assert
        assertThat(result.getId()).isNotNull();
        assertThat(result.getNombre()).isEqualTo("Prueba");
    }
    @Test
    public void testDelete() {
        // Arrange
        Entidad entidad = new Entidad();
        entidad.setNombre("Prueba");
        entidad = entityManager.persist(entidad);
        entityManager.flush();

        // Act
        entidadRepository.delete(entidad);

        // Assert
        assertThat(entidadRepository.findById(entidad.getId()).isPresent()).isFalse();
    }
}
