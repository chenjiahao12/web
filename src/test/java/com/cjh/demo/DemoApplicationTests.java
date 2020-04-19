package com.cjh.demo;

import com.cjh.demo.mapper.BookMapper;
import com.cjh.demo.model.Articles;
import com.cjh.demo.model.Book;
import com.cjh.demo.model.TreeNode;
import com.cjh.demo.model.User;

import com.cjh.demo.poi.domeweb;
import com.cjh.demo.service.ArticlesService;
import com.cjh.demo.service.BookService;
import com.cjh.demo.service.TreeNodeService;
import com.cjh.demo.service.UserService;
import com.cjh.demo.util.ExportExcelUtil;
import com.cjh.demo.util.JsonData;
import com.cjh.demo.util.PageBean;
import com.sun.media.sound.SoftTuning;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    private TreeNodeService treeNodeService;
@Autowired
private ArticlesService articlesService;



@Autowired
   private BookService bookService;
/*查询树形*/
  @Test
    public void MenuTree(){
        List<TreeNode> menuList = treeNodeService.getTree();
        System.out.println(menuList);

    }
    /*用户登录*/
@Test
    public void login(){
          User a= new User();
          a.setUname("zs");
          a.setPwd("123");
        User login = userService.login(a);
        if(login != null){
            System.out.println(login);
        }
        else{
            System.out.println("账号密码错误");
        }
    }


    @Test
    public void addPager(){
    Articles articles = new Articles();
        articles.setTitle("MySQL");
        PageBean pageBean = new PageBean();
        pageBean.setPage(1);
        List<Map> maps = articlesService.selectAllPager(articles, pageBean);
        for (Map m : maps) {
            System.out.println(m);
        }
        System.out.println(pageBean);
    }

    @Test
    public void bookPager(){
        Map map =  new HashMap();
        map.put("bname","圣墟");
        PageBean pageBean = new PageBean();
        pageBean.setPage(2);
        List<Map> maps = bookService.bookPager(map, pageBean);
        for (Map m : maps) {
            System.out.println(m);

        }
        System.out.println(pageBean);
    }
    @Test
    public void Path()throws  Exception{
        domeweb domeweb = new domeweb();
        String next = "E:\\学习资料\\导入导出\\user.xlsx";
        List<Book> read = domeweb.read(next);
        for (Book user : read) {
            int i = bookService.insertSelective(user);
        }
        System.err .println("导入成功");

    }

    @Test
    public  void getall()throws IOException {
        List<Book> bookList = bookService.getAll();
        System.out.println(bookList);
        domeweb domeweb = new domeweb();
        String next = "E:\\学习资料\\导入导出\\aaa.xlsx";
        domeweb.write(bookList,next);
        System.err.println("ok");

    }




}
