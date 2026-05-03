package com.dentali.features.auth.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

}
