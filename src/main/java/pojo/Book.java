package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int book_id;
    private String book_name;
    private String book_author;
    private int book_price;
    private String book_borrower;
    private Date book_borrow_time;
    private int book_status;
    private Date book_return_time;
    private String book_isbn;
    private Date book_publish_time;
    private int book_rec;
    private String book_press;
}
