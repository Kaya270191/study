package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//홈 컨트롤러 등록
@Controller
@Slf4j
public class HomeController {

    @RequestMapping("/") // / 로 들어오면
    public String home(){
        log.info("home controller");
        return "home"; //home으로 넘어감
    }
}
