package com.example.Julie.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Julie.model.Data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataRepository extends JpaRepository<Data, Long> {

  Data findByPage(String page);

  @Query("SELECT data FROM Data data WHERE data.id = :id")
  Data findByIdNumber(@Param("id") long id);
}
