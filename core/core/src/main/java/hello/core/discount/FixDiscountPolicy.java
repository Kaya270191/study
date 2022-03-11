package hello.core.discount;

import hello.core.order.member.Grade;
import hello.core.order.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000 원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else
            return 0;
    }
}
