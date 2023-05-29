package service;

public interface HeaderService {
    //借阅人数
    int borrowCount();
    //书籍总数
    int bookCount();
    //用户数量
    int userCount();
    //剩余书籍
    int remainBookCount();
}
