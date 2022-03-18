package jpabook.jpashop.controller;
<<<<<<< HEAD

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

//    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

=======
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
@Getter @Setter
public class MemberForm {
    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;
>>>>>>> 5c0a5fd091b0b70e4e233e922878a5005cbe6ec2
    private String city;
    private String street;
    private String zipcode;
}
