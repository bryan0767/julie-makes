package com.example.Julie.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Julie.model.*;

import com.example.Julie.repository.DataRepository;
import com.example.Julie.repository.ArticleRepository;
import com.example.Julie.repository.ImageRepository;
import com.example.Julie.repository.IconRepository;

@RestController
public class DataController {

  @Autowired
  DataRepository dataRepository;

  @Autowired
  ArticleRepository articleRepository;

  @Autowired
  ImageRepository imageRepository;

  @Autowired
  IconRepository iconRepository;

  @GetMapping("/getAll")
  public Map<String, Object> getAll() {
    Map<String, Object> data = new HashMap<>();

    dataRepository.findAll().forEach(x -> {
        HashMap<String, Object> newData = new HashMap<>();

        newData.put("description", x.getDescription());
        newData.put("page", x.getPage());
        newData.put("header", x.getHeader());
        newData.put("heroimage", x.getHeroimage());

        newData.put("articles", articleRepository.findByPage(x.getPage()));
        newData.put("images", imageRepository.findByPage(x.getPage()));
        newData.put("icons", iconRepository.findByPage(x.getPage()));

        data.put(x.getPage(), newData);
    });

    return data;
  }

  @GetMapping("/getPage")
  public Map<String, Object> getPage(@RequestParam(name="page", required = false) String page) {
    HashMap<String, Object> newData = new HashMap<>();
    Data data = dataRepository.findByPage(page);

    newData.put("description", data.getDescription());
    newData.put("page", data.getPage());
    newData.put("header", data.getHeader());
    newData.put("heroimage", data.getHeroimage());

    newData.put("articles", articleRepository.findByPage(page));
    newData.put("images", imageRepository.findByPage(page));
    newData.put("icons", iconRepository.findByPage(page));

    return newData;
  }

  @PutMapping("/editPage/{page}")
  public Map<String, Object> editPage(@PathVariable("page") String page,
                                      @RequestBody Page requestPage) {

    System.out.println( requestPage.getHeroimage() + " the hero image in the request " + requestPage.getHeader() );

    Map<String, Object> returnData = new HashMap<>();

    Data data = dataRepository.findByPage(page);

    // page data

    data.setHeader( requestPage.getHeader() );
    data.setDescription( requestPage.getDescription() );
    data.setHeroimage( requestPage.getHeroimage() );

    dataRepository.save(data);

    // images data

    List<Image> images = requestPage.getImages();

    images.forEach(x -> {
      Image image = imageRepository.findByIdNumber( x.getId() );

      image.setSrc(x.getSrc());
      imageRepository.save(image);
    });

    // icons data

    List <Icon> icons = requestPage.getIcons();

    icons.forEach(x -> {
      Icon icon = iconRepository.findByIdNumber(x.getId());

      icon.setSrc(x.getSrc());
      iconRepository.save(icon);
    });

    // articles data

    // List <Article> articles= requestPage.getArticles();
    //
    // articles.forEach(x -> {
    //   Article article = articleRepository.findByIdNumber(x.getId());
    //
    //   article.setThumbnail(x.getThumbnail());
    //   article.setHeader(x.getHeader());
    //   article.setCategory(x.getCategory());
    //   article.setDescription(x.getDescription());
    //   article.setHeroimage(x.getHeroimage());
    //   article.setContent(x.getContent());
    //   article.setLink(x.getLink());
    //
    //   articleRepository.save(article);
    // });

    Data pageData = dataRepository.findByPage(page);

    returnData.put("description", pageData.getDescription());
    returnData.put("page", pageData.getPage());
    returnData.put("header", pageData.getHeader());
    returnData.put("heroimage", pageData.getHeroimage());

    returnData.put("articles", articleRepository.findByPage(page));
    returnData.put("images", imageRepository.findByPage(page));
    returnData.put("icons", iconRepository.findByPage(page));

    return returnData;
  }

}
