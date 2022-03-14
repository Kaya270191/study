package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //생성자 자동 생성
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //인터페이스에 의존
    private final DiscountPolicy discountPolicy; //인터페이스에 의존


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) { //생성자
        System.out.println("생성자 memberRepository= " + memberRepository);
        System.out.println("생성자 discountPolicy= " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId); //회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);//할인 정책에 회원정보를 넘겨서 할인 가격을 받음

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 생성된 주문을 반환

    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
