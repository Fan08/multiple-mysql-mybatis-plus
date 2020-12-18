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
@MapperScan(basePackages = "com.tang.multiplemysqlmybatisplus.pojo.old", sqlSessionTemplateRef = "oldSqlSessionTemplate")
public class DataSourceOldConfig {

  @Bean(name = "oldDataSource")
  @ConfigurationProperties(prefix = "spring.datasource.old")
  public DataSource testDataSource() {
    System.out.println("init testDataSource");
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "oldSqlSessionFactory")
  public SqlSessionFactory oldSqlSessionFactory(@Qualifier("oldDataSource") DataSource dataSource) throws Exception {
    //SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    bean.setTypeEnumsPackage("com.tang.multiplemysqlmybatisplus.enums");
    bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/old/*.xml"));
    return bean.getObject();
  }

  @Bean(name = "oldSqlSessionTemplate")
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("oldSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
