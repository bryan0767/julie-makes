package com.example.Julie.model;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

  public User() { }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
