package controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Header;
import service.HeaderService;

/**
 * 该类实现首页卡片的值
 */
@Controller
public class HeaderController {
    @Autowired
    HeaderService headerService;
    @RequestMapping("/header")
    public void uploadHeader(HttpServletRequest request){
        Header header = new Header();
        header.setBookCount(headerService.bookCount());
        header.setUserCount(headerService.userCount());
        header.setRemainBookCount(headerService.remainBookCount());
        header.setBorrowCount(headerService.borrowCount());
        request.getSession().setAttribute("HEADER_SESSION", header);
    }
}
