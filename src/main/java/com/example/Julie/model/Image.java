package com.example.Julie.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @Column(name = "id")
  private long id;

	@Column(name = "src")
	private String src;

	@Column(name = "page")
	private String page;

  public Image() {};

	public Image(String page, String src) {
    this.src = src;
    this.page = page;
	}

  public long getId() {
    return id;
  }

	public String getPage() {
    return page;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }
}
