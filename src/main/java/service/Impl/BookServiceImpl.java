package service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.BookMapper;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import service.BookService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int borrowBook(Book book) {
        //根据id查询出需要借阅的完整图书信息
        Book b = this.selectBookById(String.valueOf(book.getBook_id()));
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //设置当天为借阅时间
        book.setBook_borrow_time(dateFormat.format(new Date()));
        //设置所借阅的图书状态为借阅中
        book.setBook_status(1);
        //将图书的价格设置在book对象中
        book.setBook_price(b.getBook_price());
        //将图书的上架设置在book对象中
        book.setBook_publish_time(b.getBook_publish_time());
        return bookMapper.editBook(book);
    }

    @Override
    public PageResult searchConfirmBook() {
        Page<Book> page = bookMapper.searchConfirmBook();
        return new PageResult(page.getTotal(), page.getResult());
    }
}
