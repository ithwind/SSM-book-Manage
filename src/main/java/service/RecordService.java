package service;

import entity.PageResult;
import pojo.Record;
import pojo.User;

public interface RecordService {
    /**
     * 查询当前借阅图书
     */
    PageResult searchBorrow(String username);
    /**
     * 归还图书
     */
    boolean returnBook(String bookId, User user);


    int confirmBook(String id);
    /**
     * 查询已经归还的图书
     */
    PageResult searchRecord(User user);
    /**
     * 新增借阅记录
     */
    int addRecord(Record record);
}
