package com.example.Julie.model;

import javax.persistence.*;

@Entity
@Table(name = "icons")
public class Icon {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
  @Column(name = "id")
  private long id;

	@Column(name = "src")
	private String src;

	@Column(name = "class")
	private String className;

	@Column(name = "page")
	private String page;

  public Icon() {};

	public Icon(String src, String className, String page) {
    this.src = src;
    this.className = className;
		this.page = page;
	}

	public long getId() {
		return id;
	}

  public String getClassName() {
    return className;
  }

  public String getSrc() {
    return src;
  }

  public String getPage() {
    return page;
  }

	public void setSrc(String src) {
    this.src = src;
  }
}
