package service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.BookMapper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public PageResult selectRecBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Book> books = bookMapper.selectRecBook();
        return new PageResult(books.getTotal(),books.getResult());
    }

    @Override
    public PageResult SearchBook(String inputContent) {
        PageHelper.startPage(1, 10);
        Page<Book> books = bookMapper.searchBook(inputContent);
        return new PageResult(books.getTotal(), books.getResult());

    }

    @Override
    public Book selectBookById(String id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public int editBook(Book book) {
        return bookMapper.editBook(book);
    }
}
