package com.example.Julie.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Julie.model.Icon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IconRepository extends JpaRepository<Icon, Long> {
  List<Icon> findByPage(String page);

  @Query("SELECT icon FROM Icon icon WHERE icon.id = :id")
  Icon findByIdNumber(@Param("id") long id);
}
