package hello.core;

import hello.core.order.member.Grade;
import hello.core.order.member.Member;
import hello.core.order.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


//  ApplicationContext 스프링 컨테이너
        //스프링 컨테이너가 AppCofig에 저장된 환경설정 정보 가지고 @bean 을 스프링 컨테이너에 다 넣어서 관리함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//매개변수(메서드 이름, 반환 타입)

//        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(" new member = "+ member.getName());
        System.out.println(" findMember=" + findMember.getName());
    }
}
