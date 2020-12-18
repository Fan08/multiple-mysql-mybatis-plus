package com.tang.multiplemysqlmybatisplus.mapper.news;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.multiplemysqlmybatisplus.pojo.news.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
  List<Map> selectTestWithSqlInXml();
}
