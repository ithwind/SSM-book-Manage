package service;

import com.github.pagehelper.Page;
import entity.PageResult;
import org.apache.ibatis.annotations.Update;
import pojo.Book;

import java.util.List;

public interface BookService {
    /**
     * 查询推荐图书
     */
    PageResult selectRecBook(Integer pageNum, Integer pageSize);
    /**
     * 根据书名搜索相应图书
     * @param inputContent 输入的关键字可为书名或者作者名
     */
    PageResult SearchBook(String inputContent);
    /**
     * 通过id查询书籍用于书籍增删改查
     */
    Book selectBookById(String id);

    /**
     * 修改书籍数据
     */
    int editBook(Book book);
    /**
     * 添加图书
     */
    int addBook(Book book);

}
