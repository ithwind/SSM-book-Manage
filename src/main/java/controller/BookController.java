package controller;

import entity.PageResult;
import entity.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import service.BookService;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/book")
    public String ToBook(){
        return "book_manage";
    }



    @RequestMapping("/selectRecBook")
    public ModelAndView selectRecBook(HttpServletRequest request){
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageResult pageResult = bookService.selectRecBook(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book_rec");
        modelAndView.addObject("pageResult", pageResult);
        return modelAndView;
    }


    @RequestMapping("/book_manage")
    public ModelAndView searchBook(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        PageResult searchBook = bookService.SearchBook(request.getParameter("inputContent"));
        modelAndView.setViewName("book_manage");
        modelAndView.addObject("searchBooks", searchBook);
        if (searchBook.getTotal() == 0){
            request.setAttribute("msg", "暂无此书籍");
        }
        System.out.println(searchBook.getRows());
        return modelAndView;
    }

    /**
     * 根据图书id查询图书信息
     * @param id 查询的图书id
     */
    @ResponseBody
    @RequestMapping("/findById")
    public Result<Book> findById(String id) {
        try {
            Book book=bookService.selectBookById(id);
            if(book==null){
                return new Result<Book>(false,"查询图书失败！");
            }
            return new Result<Book>(true,"查询图书成功",book);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<Book>(false,"查询图书失败！");
        }
    }

    /**
     * 修改图书
     */
    @ResponseBody
    @RequestMapping("/editBook")
    public Result<Object> editBook(Book book){
        try {
            int count= bookService.editBook(book);
            System.out.println(book);
            if(count!=1){
                return new Result<Object>(false, "编辑失败!");
            }
            return new Result<Object>(true, "编辑成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<Object>(false, "编辑失败!");
        }
    }
}
