package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
=======
//홈 컨트롤러 등록
>>>>>>> 5c0a5fd091b0b70e4e233e922878a5005cbe6ec2
@Controller
@Slf4j
public class HomeController {

<<<<<<< HEAD
    @RequestMapping("/")
    public String home(){
        log.info("home controller");
        return "home";
=======
    @RequestMapping("/") // / 로 들어오면
    public String home(){
        log.info("home controller");
        return "home"; //home으로 넘어감
>>>>>>> 5c0a5fd091b0b70e4e233e922878a5005cbe6ec2
    }
}
