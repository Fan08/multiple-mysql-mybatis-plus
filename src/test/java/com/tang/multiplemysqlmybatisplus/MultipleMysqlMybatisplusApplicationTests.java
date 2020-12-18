package com.tang.multiplemysqlmybatisplus;

import com.tang.multiplemysqlmybatisplus.mapper.news.UserMapper;
import com.tang.multiplemysqlmybatisplus.mapper.old.BlogMapper;
import com.tang.multiplemysqlmybatisplus.pojo.news.User;
import com.tang.multiplemysqlmybatisplus.pojo.old.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MultipleMysqlMybatisplusApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private BlogMapper blogMapper;

  @Test
  void testNewsUser() {
    List<User> users = userMapper.selectByMap(null);
    for (User user : users) {
      System.out.println(user.toString());
    }
  }

  @Test
  void testOldBlog() {
    List<Blog> blogs = blogMapper.selectByMap(null);
    for (Blog blog : blogs) {
      System.out.println(blog.toString());
    }
  }

  @Test
  void testSqlXml() {
    // old
    List<Map> blogs = blogMapper.selectTestWithSqlInXml2();
    for (Map blog : blogs) {
      System.out.println(blog.toString());
    }
  }

  @Test
  void testSqlXml2() {
    // news
    List<Map> users = userMapper.selectTestWithSqlInXml();
    for (Map user : users) {
      System.out.println(user.toString());
    }
  }
}
