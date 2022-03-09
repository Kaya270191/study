package hello.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute( "data", "spring!!");
        return "hello"; //탬플릿의 hello.html로 보내라
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody // 바디에 내용을 직접 넣어 주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody // 제이슨으로 반환함
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //객체 생성
        hello.setName(name);
        return hello; //객체 반환
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {

            this.name = name;
        }
    }


}
