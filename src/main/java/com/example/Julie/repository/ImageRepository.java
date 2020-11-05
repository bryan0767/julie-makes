package com.example.Julie.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Julie.model.Image;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long> {
  List<Image> findByPage(String page);


  @Query("SELECT image FROM Image image WHERE image.id = :id")
  Image findByIdNumber(@Param("id") long id);
}
