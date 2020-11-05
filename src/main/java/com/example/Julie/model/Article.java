package com.example.Julie.model;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;

  	@Column(name = "thumbnail")
  	private String thumbnail;

  	@Column(name = "header")
  	private String header;

  	@Column(name = "category")
  	private String category;

    @Column(name = "description")
  	private String description;

    @Column(name = "date")
  	private String date;

    @Column(name = "heroimage")
  	private String heroimage;

    @Column(name = "content")
  	private String content;

    @Column(name = "link")
  	private String link;

    @Column(name = "page")
  	private String page;

    public Article() {}

    public Article(String thumbnail,
                   String header,
                   String category,
                   String description,
                   String heroimage,
                   String content,
                   String link,
                   String page) {
      this.thumbnail = thumbnail;
  		this.header = header;
      this.category = category;
  		this.description = description;
      this.heroimage = heroimage;
      this.content = content;
      this.link = link;
  		this.page = page;
  	}

    public long getId() {
      return id;
    }

    public String getThumbnail() {
  		return thumbnail;
  	}

  	public String getHeader() {
  		return header;
  	}

    public String getCategory() {
  		return category;
  	}

    public String getDescription() {
  		return description;
  	}

    public String getDate() {
  		return date;
  	}

  	public String getHeroimage() {
  		return heroimage;
  	}

    public String getContent() {
      return content;
    }

    public String getLink() {
      return link;
    }

  	public String getPage() {
      return page;
    }

    public void setThumbnail(String thumbnail) {
      this.thumbnail = thumbnail;
    }

  	public void setHeader(String header) {
  		this.header = header;
  	}

    public void setCategory(String category) {
  		this.category = category;
  	}

  	public void setDescription(String description) {
  		this.description = description;
  	}

    public void setDate(String date) {
      this.date = date;
    }

  	public void setHeroimage(String heroimage) {
  		this.heroimage = heroimage;
  	}

    public void setContent(String content) {
      this.content = content;
    }

    public void setLink(String link) {
      this.link = link;
    }

    public void setPage(String page) {
      this.page = page;
    }

}
