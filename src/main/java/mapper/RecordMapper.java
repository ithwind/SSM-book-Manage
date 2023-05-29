package mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import pojo.Book;
import pojo.Record;
import pojo.User;

public interface RecordMapper {

    @Select("select * from book where book_borrower = #{username} and book_status != 3")
    Page<Book> searchBorrow(String username);
    @Select("select * from record where borrower = #{username}")
    Page<Record> searchRecord(User user);

    @Insert("insert into record(borrow_book_name, borrow_time, return_time, borrower, borrow_book_isbn)" +
            "values(#{borrow_book_name}, #{borrow_time}, #{return_time}, #{borrower},#{borrow_book_isbn})")
    int addRecord(Record record);
}
