package controller;

import entity.PageResult;
import entity.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import pojo.User;
import service.BookService;


@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    HeaderController headerController;
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
    public Result<Object> editBook(Book book, HttpServletRequest request){
        try {
            int count= bookService.editBook(book);
            System.out.println(book);
            headerController.uploadHeader(request);
            if(count!=1){
                return new Result<>(false, "编辑失败!");
            }
            return new Result<>(true, "编辑成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false, "编辑失败!");
        }
    }

    /**
     * 添加图书
     */
    @ResponseBody
    @RequestMapping(value = "/addBook")
    public Result<Object> addBook(@RequestBody  Book book, HttpServletRequest request) {
        try {
            System.out.println(book);
            int count=bookService.addBook(book);
            if(count!=1){
                return new Result<>(false, "新增图书失败!");
            }
            headerController.uploadHeader(request);
            return new Result<>(true, "新增图书成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false, "新增图书失败!");
        }
    }
    /**
     * 借阅图书
     */
    @ResponseBody
    @RequestMapping("/book_borrow")
    public Result<Object> borrowBook(Book book, HttpSession session, HttpServletRequest request) {
        //获取当前登录的用户姓名
        String username = ((User) session.getAttribute("USER_SESSION")).getUsername();
        System.out.println(username);
        book.setBook_borrower(username);
        try {
            //根据图书的id和用户进行图书借阅
            System.out.println("borrowBook:"+book);
            int count = bookService.borrowBook(book);
            if (count != 1) {
                return new Result<>(false, "借阅图书失败!");
            }
            headerController.uploadHeader(request);
            return new Result<>(true, "借阅成功，请到行政中心取书!");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, "借阅图书失败!");
        }
    }
    /**
     * 返回图书借阅视图
     */
    @RequestMapping("/searchBorrowBook")
    public ModelAndView searchBorrowBook(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        PageResult searchBook = bookService.SearchBook(request.getParameter("inputContent"));
        modelAndView.setViewName("book_borrow");
        modelAndView.addObject("searchBooks", searchBook);
        if (searchBook.getTotal() == 0){
            request.setAttribute("msg", "暂无此书籍");
        }
        System.out.println(searchBook.getRows());
        return modelAndView;
    }
}
