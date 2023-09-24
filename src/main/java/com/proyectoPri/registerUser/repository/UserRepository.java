package com.proyectoPri.registerUser.repository;

import com.proyectoPri.registerUser.dtos.responses.SearchUserByEmail;
import com.proyectoPri.registerUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByname(String name);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT u.name, u.email FROM User u WHERE u.email = :email")
    Optional<Object[]> findNameAndEmailByEmail(@Param("email") String email);

    @Query("SELECT NEW com.proyectoPri.registerUser.dtos.responses.SearchUserByEmail (u.name, u.email) FROM User u WHERE u.email = :email")
    Optional<SearchUserByEmail> findNameAndEmailKeyValue(@Param("email") String email);
}
