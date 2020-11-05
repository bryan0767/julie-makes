package com.example.Julie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Julie.model.Article;
import com.example.Julie.repository.ArticleRepository;

@RestController
public class ArticleController {

  @Autowired
  ArticleRepository articleRepository;

  // Get All Articles

  @GetMapping("/getAllArticles")
  public List<Article> getAllArticles() {
    return articleRepository.findAll();
  }

  // Get Single Article

  @GetMapping("/getArticle/{id}")
  public Article getArticle(@PathVariable("id") Long id) {
    return articleRepository.findByIdNumber(id);
  }

  // Post New Article

  @PostMapping("/postArticle")
  public Article postArticle(@RequestBody Article article) {
    return articleRepository.save(article);
  }

  // Edit Article

  @PutMapping("/editArticle/{id}")
  public Article editArticle(@PathVariable("id") Long id,
                             @RequestBody Article newArticle) {

   Article article = articleRepository.findByIdNumber(id);

   article.setThumbnail(newArticle.getThumbnail());
   article.setHeader(newArticle.getHeader());
   article.setCategory(newArticle.getCategory());
   article.setDescription(newArticle.getDescription());
   article.setHeroimage(newArticle.getHeroimage());
   article.setContent(newArticle.getContent());
   article.setLink(newArticle.getLink());
   article.setPage(newArticle.getPage());

   return articleRepository.save(article);
  }

  // Delete Article

  @DeleteMapping("/deleteArticle/{id}")
  public String deleteArticle(@PathVariable("id") Long id) {
    articleRepository.deleteById(id);
    return "Deleted!";
  }

}
