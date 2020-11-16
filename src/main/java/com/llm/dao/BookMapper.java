package com.llm.dao;

import com.llm.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("bookId") int id);

    //查询所有书
    List<Books> queryAllBooks();

    //由于id是自增加的，当删除出表的时候，主键id不连续问题
    //每次执行删除操作后，执行sql语句，重置自增加，可以使用aop编程技术实现，也可以简单调用代码
    void resetAutoIncrement();

    //根据书名查询书籍
    Books queryBookByName(@Param("bookName") String bookName);
}
