package com.example.Julie.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Julie.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<User, Long> {
  @Query("SELECT user FROM User user WHERE user.username = :username AND user.password = :password")
  User validate(@Param("username") String username, @Param("password") String password );
}
