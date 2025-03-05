package com.kdr.CrediGo.repository;

import com.kdr.CrediGo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Utilizes Spring Data JPA, that simplifies database operations (CRUD) using Hibernate (ORM)
 * Allows the use of repositories to interact with entities
 *
 * Extends JpaRepository, hence can use existing database operations from Spring Data JPA
 */

public interface UserRepository extends JpaRepository<User, Long> {

    /*
        TIP: start with existsBy as this autocompletes the parameters
     */
    Boolean existsByEmail(String email);
}
