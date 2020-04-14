package com.cjh.demo.service.impl;

import com.cjh.demo.mapper.ArticlesMapper;
import com.cjh.demo.model.Articles;
import com.cjh.demo.service.ArticlesService;
import com.cjh.demo.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2020-04-11 15:41
 */
@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;


    @Override
    public List<Map> selectAllPager(Articles record, PageBean pageBean) {
        return articlesMapper.selectAllPager(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articlesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Articles record) {
        return 0;
    }

    @Override
    public int insertSelective(Articles record) {
        return articlesMapper.insertSelective(record);
    }

    @Override
    public Articles selectByPrimaryKey(Integer id) {
        return articlesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Articles record) {
        return articlesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Articles record) {
        return articlesMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Articles record) {
        return articlesMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map> selectAllPager(Articles record) {
        return null;
    }
}
