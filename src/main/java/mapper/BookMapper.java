package mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Book;



public interface BookMapper {

    @Select("select * from book where book_status != 3 order by book_publish_time desc")
    Page<Book> selectRecBook();

    @Select("select * from book where book_status != 3 and book_name = #{inputContent} or book_author = #{inputContent}")
    Page<Book> searchBook(String inputContent);

    @Select("select * from book where book_id = #{id}")
    Book selectBookById(String id);


    int editBook(Book book);

    int addBook(Book book);
}
