package com.cjh.demo.service;



import com.cjh.demo.model.Book;
import com.cjh.demo.util.PageBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @site
 * @company
 * @create 2019-11-09 11:08
 */
public interface BookService {

    int deleteByPrimaryKey(Integer bid);


    @Cacheable(value = "my-redis-cache2",key = "'book'+#bid",condition = "#bid<20")
    Book selectByPrimaryKey(Integer bid);

    List<Map> bookPager(Map map, PageBean pageBean);

    @CachePut(value = "my-redis-cache2")
    Book selectByPrimaryKey1(Integer bid);

    @CacheEvict(value="my-redis-cache2",allEntries = true)
    void clear();

}
