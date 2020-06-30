package com.spring.herseyvar.repositories;

import com.spring.herseyvar.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAll();

}
