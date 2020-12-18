package com.tang.multiplemysqlmybatisplus.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.mybatis.spring.SqlSessionTemplate;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.tang.multiplemysqlmybatisplus.pojo.news", sqlSessionTemplateRef = "newsSqlSessionTemplate")
public class DataSourceNewsConfig {

  @Bean(name = "newsDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.news")
  public DataSource testDataSource() {
    System.out.println("init testnewsDataSource");
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "newsSqlSessionFactory")
  @Primary
  public SqlSessionFactory newsSqlSessionFactory(@Qualifier("newsDataSource") DataSource dataSource) throws Exception {
    //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setTypeEnumsPackage("com.tang.multiplemysqlmybatisplus.enums");
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/news/*.xml"));
    return bean.getObject();
  }

  @Bean(name = "newsSqlSessionTemplate")
  @Primary
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("newsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}