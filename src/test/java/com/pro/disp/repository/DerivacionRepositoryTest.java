package com.pro.disp.repository;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.pro.disp.Entity.Derivacion;
import com.pro.disp.Entity.Providencia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)

class DerivacionRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DerivacionRepository derivacionRepository;

    @Test
    public void testFindLastByProvidencia() {
        // Arrange
        Providencia providencia = new Providencia(); // You might need to set up Providencia entity as well
        // Set up other necessary fields in Providencia entity

        Derivacion derivacion = new Derivacion();
        derivacion.setProvidencia(providencia);
        // Set up other necessary fields in Derivacion entity
        derivacion = entityManager.persist(derivacion);
        entityManager.flush();

        // Act
        List<Derivacion> result = derivacionRepository.findLastByProvidencia(providencia);

        // Assert
        assertThat(result.size()).isGreaterThan(0);
        // Add more assertions based on your requirements
    }

}