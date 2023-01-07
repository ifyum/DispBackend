package com.pro.disp.repository;


import com.pro.disp.Entity.Jhi_user;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<Jhi_user, Long> {

    String USERS_BY_LOGIN_CACHE = "usersByLogin";

    String USERS_BY_EMAIL_CACHE = "usersByEmail";

    Optional<Jhi_user> findOneByActivationKey(String activationKey);

    List<Jhi_user> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

    Optional<Jhi_user> findOneByResetKey(String resetKey);

    Optional<Jhi_user> findOneByEmailIgnoreCase(String email);

    Optional<Jhi_user> findOneByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    Optional<Jhi_user> findOneWithAuthoritiesById(Long id);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<Jhi_user> findOneWithAuthoritiesByLogin(String login);

    @EntityGraph(attributePaths = "authorities")
    @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
    Optional<Jhi_user> findOneWithAuthoritiesByEmail(String email);

    @Query("select u from Jhi_user u where u.perfil.id = :perfilId order by u.id desc ")
    List<Jhi_user> findByPerfilId(@Param("perfilId") Long perfilId);

//    @Query("select u from User where u.grupo.id=:grupoId")
//    List<User>findbyGrupoId(@Param("grupoId") Grupo grupoId);

    @Query("SELECT u.id FROM Jhi_user u WHERE u.grupo.id = :grupoId")
    List<Long> findByAllGrupo(@Param("grupoId") Long grupoId);


    @Query("SELECT u FROM Jhi_user u WHERE CONCAT(LOWER(u.firstName), ' ', LOWER(u.lastName)) = :fullname")
    Optional<Jhi_user> findByFullName(@Param("fullname") String fullname);

    Page<Jhi_user> findAllByLoginNot(Pageable pageable, String login);

    @Modifying
    @Query("UPDATE Jhi_user u SET u.activated = :newStatus, u.lastModifiedDate = :modifyDate, u.lastModifiedBy = :lastModifiedBy WHERE u.id = :idUser")
    void updateActivationStatus(@Param("newStatus") Boolean newStatus, @Param("modifyDate") Instant modifyDate,
                                @Param("lastModifiedBy") String lastModifiedBy ,@Param("idUser") Long idUser);

//    @Query(value = "select distinct usuario from User usuario left join fetch usuario.grupos")
//    Set<User> findAllUsersByGroup();
}

