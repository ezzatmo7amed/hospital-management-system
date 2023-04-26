package com.hospital.api.repository;


import com.hospital.api.model.usermanagement.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);


    Optional<User> findByUsernameAndPassword(String username,String password);
    @Query(value = "select email from users where id=:id",nativeQuery = true)
    String findEmailWithId(Long id);
}
