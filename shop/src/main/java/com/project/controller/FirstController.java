package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //hi 라는 url 입력받았으면
    public String niceToMeetYou(){
        return"greetings"; //templates/greetings.mustache -> 보여줄 페이지
    }
}
