package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    private int borrow_book_id;//借阅图书id
    private String borrow_book_name;//借阅图书name
    private String borrow_book_isbn;//借阅书籍ISBN
    private String borrower;//借阅者
    private String borrow_time;//借阅图书时间
    private String return_time;//还书时间
}
