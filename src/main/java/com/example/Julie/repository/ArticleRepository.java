package com.example.Julie.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Julie.model.Article;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  @Query("SELECT article FROM Article article WHERE article.id = :id")
  Article findByIdNumber(@Param("id") long id);

  List<Article> findByPage(String page);
}
