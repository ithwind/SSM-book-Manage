package controller;

import entity.PageResult;
import entity.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import pojo.User;
import service.BookService;
import service.RecordService;

@Controller
public class RecordController {

    @Autowired
    RecordService recordService;
    @Autowired
    BookService bookService;
    /**
     * 查询借阅书籍记录
     */

    @RequestMapping("/searchBorrow")
    public ModelAndView searchBorrow(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        ModelAndView modelAndView = new ModelAndView();
        PageResult borrow_book = recordService.searchBorrow(user.getUsername());
        modelAndView.setViewName("record_borrow");
        modelAndView.addObject("borrow_book", borrow_book);
        modelAndView.addObject("goUrl", request.getRequestURI());

        return modelAndView;
    }
    /**
     * 还书操作
     */
    /**
     * 归还图书
     * @param id 归还的图书的id
     */
    @ResponseBody
    @RequestMapping("/returnBook")
    public Result<Object> returnBook(String id, HttpSession session) {
        //获取当前登录的用户信息
        User user = (User) session.getAttribute("USER_SESSION");
        try {
            boolean flag = recordService.returnBook(id, user);
            if (!flag) {
                return new Result<>(false, "还书失败!");
            }
            return new Result<>(true, "还书确认中，请先到行政中心还书!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false, "还书失败!");
        }
    }
    /**
     * 管理员确认图书已经归还
     */
    @RequestMapping("/confirmBook")
    public ModelAndView confirmBook(String id) {
        ModelAndView modelAndView = new ModelAndView();
        PageResult confirmBook = bookService.searchConfirmBook();
        modelAndView.setViewName("borrow_manage");
        modelAndView.addObject("confirmBook", confirmBook);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/confirmReturn")
    public Result<Object> confirmReturn(String id){
        try {
            int count=recordService.confirmBook(id);
            if(count!=1){
                return new Result<>(false, "确认失败!");
            }
            return new Result<>(true, "确认成功!");
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false, "确认失败!");
        }
    }

    @RequestMapping("/recordHistory")
    public ModelAndView recordHistory(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User) request.getSession().getAttribute("USER_SESSION");
        PageResult record_history = recordService.searchRecord(user);
        System.out.println(record_history.getRows());
        modelAndView.setViewName("record_history");
        modelAndView.addObject("record_history", record_history);
        return modelAndView;
    }
}
