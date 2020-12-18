package com.tang.multiplemysqlmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.tang.multiplemysqlmybatisplus.mapper")
public class MultipleMysqlMybatisplusApplication {

  public static void main(String[] args) {
    SpringApplication.run(MultipleMysqlMybatisplusApplication.class, args);
  }

}
