package com.example.Julie.model;

import java.util.*;
import com.example.Julie.model.*;

public class Page {
  private String header;
  private String description;
  private String heroimage;
  private List<Image> images;
  private List<Icon> icons;
  private List<Article> articles;

  public Page() {};

  public Page( String header,
               String description,
               String heroimage,
               List<Image> images,
               List<Icon> icons,
               List<Article> articles ) {
    this.header = header;
    this.description = description;
    this.heroimage = heroimage;
    this.images = images;
    this.icons = icons;
    this.articles = articles;
  }

  public String getHeader() {
    return header;
  }

  public String getDescription() {
    return description;
  }

  public String getHeroimage() {
    return heroimage;
  }

  public List<Image> getImages() {
    return images;
  }

  public List<Icon> getIcons() {
    return icons;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setHeader( String header ) {
    this.header = header;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHeroimage(String heroimage) {
    this.heroimage = heroimage;
  }

  public void setImages( List<Image> images ) {
    this.images = images;
  }

  public void setIcons(List<Icon> icons) {
    this.icons = icons;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}
