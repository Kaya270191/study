package hello.core.discount;

import hello.core.order.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
