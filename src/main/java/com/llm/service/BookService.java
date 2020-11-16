package com.llm.service;

import com.llm.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询所有书
    List<Books> queryAllBooks();

    //重置自动增长
    void resetAutoIncrement();

    //根据书名查询书籍
    Books queryBookByName(@Param("bookName") String bookName);
}
