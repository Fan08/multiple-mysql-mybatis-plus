package com.tang.multiplemysqlmybatisplus.mapper.old;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.multiplemysqlmybatisplus.pojo.old.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BlogMapper extends BaseMapper<Blog> {
  List<Map> selectTestWithSqlInXml2();
}
