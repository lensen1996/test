package com.llm.controller;


import com.llm.entity.Books;
import com.llm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * controller层调用service层，实现页面调用
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部页面，返回一个展示数据页面
    @RequestMapping("/allBooks")
    public String getAllBooks(Model model){
        System.out.println("----显示所有书籍----" + model);
        List<Books> list = bookService.queryAllBooks();
        model.addAttribute("list", list);
        System.out.println("========model=======" + model);
        return "allBooks";
    }

    //增加书籍页面
    @RequestMapping("/addBook")
    public String addBook(){
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/insertBook")
    public String insertBook(Books books){
        System.out.println("书籍添加----->" + books);
        bookService.addBook(books);
        return "redirect:/book/allBooks";   //重定向回去
    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        System.out.println("-----删除书籍-----" + id );
        bookService.deleteBookById(id);
        bookService.resetAutoIncrement();
        return "redirect:/book/allBooks";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model){
        System.out.println("----进入修改书籍页面----" + id);
        Books books = bookService.queryBookById(id);
        model.addAttribute("book",books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("----修改书籍页面----" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBooks";
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBook, Model model){
        System.out.println("------查询书籍界面-------" + queryBook);
        Books result = bookService.queryBookByName(queryBook);
        if(result == null){
            return "error";
        }
        List<Books> list = new ArrayList<Books>();
        list.add(result);
        model.addAttribute("list", list);
        return "allBooks";
    }

}
