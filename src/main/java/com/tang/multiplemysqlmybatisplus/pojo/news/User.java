package com.tang.multiplemysqlmybatisplus.pojo.news;

import java.util.Date;

public class User {
  private int id;
  private String name;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User() {
  }

  public User(int id, String name, int age, String email, Date create_time, Date update_time, int version, int deleted) {
    this.id = id;
    this.name = name;
  }
}
