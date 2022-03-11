package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.order.member.Member;
import hello.core.order.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //인터페이스에 의존
    private final DiscountPolicy discountPolicy; //인터페이스에 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
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
