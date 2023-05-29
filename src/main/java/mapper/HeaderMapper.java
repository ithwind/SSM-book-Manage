package mapper;

import org.apache.ibatis.annotations.Select;

public interface HeaderMapper {

    //借阅人数
    @Select("select count(0) from book where book_status = 1 or book_status = 2")
    int borrowCount();
    //书籍总数
    @Select("select count(0) from book where book_status != 3")
    int bookCount();
    //用户数量
    @Select("select count(0) from user")
    int userCount();
    //剩余书籍
    @Select("select count(0) from book where book_status = 0")
    int remainBookCount();

}
