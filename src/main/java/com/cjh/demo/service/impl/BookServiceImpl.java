package com.cjh.demo.service.impl;

import com.cjh.demo.mapper.BookMapper;
import com.cjh.demo.model.Book;
import com.cjh.demo.service.BookService;
import com.cjh.demo.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2019-11-09 11:09
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public int deleteByPrimaryKey(Integer bid) {
        return bookMapper.deleteByPrimaryKey(bid);
    }

    @Override
    public Book selectByPrimaryKey(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public List<Map> bookPager(Map map, PageBean pageBean) {
        return bookMapper.bookPager(map);
    }
    @Override
    public Book selectByPrimaryKey1(Integer bid) {
        return bookMapper.selectByPrimaryKey(bid);
    }

    @Override
    public void clear() {
        System.out.println("清空缓存");
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.getAll();
    }

}
