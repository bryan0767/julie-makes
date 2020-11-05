package com.example.Julie.model;

import javax.persistence.*;

@Entity
@Table(name = "pagedata")
public class Data {

	@Id
	@Column(name = "id")
	private long id;

  @Column(name = "page")
  private String page;

	@Column(name = "header")
	private String header;

	@Column(name = "description")
	private String description;

	@Column(name = "heroimage")
	private String heroimage;

  public Data() {}

	public Data(String header, String description, String heroimage, String page) {
		this.header = header;
		this.description = description;
    this.heroimage = heroimage;
		this.page = page;
	}

	public long getId() {
		return id;
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

	public String getPage() {
    return page;
  }

	public void setHeader(String header) {
		this.header = header;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHeroimage(String heroimage) {
		this.heroimage = heroimage;
	}

  public void setPage(String page) {
    this.page = page;
  }

}
