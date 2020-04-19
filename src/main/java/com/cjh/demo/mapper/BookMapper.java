package com.cjh.demo.mapper;



import com.cjh.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookMapper {
        int deleteByPrimaryKey(Integer bid);

        int insert(Book record);

        int insertSelective(Book record);

        Book selectByPrimaryKey(Integer bid);

        int updateByPrimaryKeySelective(Book record);

        int updateByPrimaryKey(Book record);

        List<Map> bookPager(Map map);

        List<Book> getAll();
}