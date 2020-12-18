package com.tang.multiplemysqlmybatisplus.pojo.old;

import java.util.Date;

public class Blog {
  private String id;
  private String title;
  private String author;
  private Date create_time;
  private int views;

  @Override
  public String toString() {
    return "Blog{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", create_time=" + create_time +
            ", views=" + views +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public Blog() {
  }

  public Blog(String id, String title, String author, Date create_time, int views) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.create_time = create_time;
    this.views = views;
  }
}
