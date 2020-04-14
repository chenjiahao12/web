package com.cjh.demo.service;

import com.cjh.demo.model.Articles;
import com.cjh.demo.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 15:40
 */
@Repository
public interface ArticlesService {
    List<Map> selectAllPager(Articles record, PageBean pageBean);

    int deleteByPrimaryKey(Integer id);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKeyWithBLOBs(Articles record);

    int updateByPrimaryKey(Articles record);

    List<Map> selectAllPager(Articles record);
}
