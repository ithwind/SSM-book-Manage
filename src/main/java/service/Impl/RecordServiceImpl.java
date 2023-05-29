package service.Impl;

import com.github.pagehelper.Page;
import entity.PageResult;
import mapper.BookMapper;
import mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import pojo.Record;
import pojo.User;
import service.BookService;
import service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    @Autowired
    BookService bookService;

    @Override
    public PageResult searchBorrow(String username) {
        Page<Book> borrowBook = recordMapper.searchBorrow(username);
        return new PageResult(borrowBook.getTotal(), borrowBook.getResult());
    }

    @Override
    public boolean returnBook(String bookId, User user) {
        Book book = bookService.selectBookById(bookId);
        boolean flag = book.getBook_borrower().equals(user.getUsername());//确认还书用户与借阅者是否一致
        if(flag){
            book.setBook_status(2);
            System.out.println("borrowBook" + book);
            bookService.editBook(book);
        }
        return flag;
    }

    @Override
    public int confirmBook(String id) {
        //根据图书id查询图书的完整信息
        Book book = bookService.selectBookById(id);
        //根据归还确认的图书信息，设置借阅记录
        Record record = setRecord(book);
        //将图书的借阅状态修改为可借阅
        book.setBook_status(0);
        //清除当前图书的借阅人信息
        book.setBook_borrower("");
        //清除当前图书的借阅时间信息
        book.setBook_borrow_time("");
        //清除当亲图书的预计归还时间信息
        book.setBook_return_time("");
        int count= bookService.editBook(book);
        //如果归还确认成功，则新增借阅记录
        if(count == 1){
            return addRecord(record);
        }
        return 0;
    }

    @Override
    public PageResult searchRecord(User user) {
        Page<Record> page = recordMapper.searchRecord(user);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public int addRecord(Record record) {
        return recordMapper.addRecord(record);
    }

    /**
     * 添加记录
     */
    public Record setRecord(Book book){
        Record record = new Record();
        record.setBorrow_book_id(book.getBook_id());
        record.setBorrow_book_name(book.getBook_name());
        record.setBorrow_book_isbn(book.getBook_isbn());
        record.setBorrower(book.getBook_borrower());
        record.setBorrow_time(book.getBook_borrow_time());
        record.setReturn_time(book.getBook_return_time());

        return record;
    }
}
