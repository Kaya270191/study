package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //hi 라는 url 입력받았으면    http://localhost:8030/hi 로 들어오면
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "사랑해"); //모델이라는 객체가 {username} 에 공주님이 담기게
        return"greetings"; //  templates/greetings.mustache -> 보여줄 페이지 greeting.mustache 를 보여줌
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "가영" );
        return "goodbye"; //보여줄 뷰페이지
    }

    @GetMapping("/morning")
    public String goodMorning(Model model){
        model.addAttribute("date", "11.22.03");
        model.addAttribute("place","대구");
        return "gdmorning";
    }


}
