package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//자동으로 스프링 빈에 등록됨
@Service
@Transactional(readOnly = true)  //스프링이 제공하는 것 쓰기 //JPA가 찾는 데 성능을 최적화함
@RequiredArgsConstructor //생성자
public class MemberService {


    private final MemberRepository memberRepository; //final!!

    //회원 가입
    @Transactional //우선권
    public Long join(Member member){
        validateDuplicateMember(member); //중복회원검증
        memberRepository.save(member); //멤버 리포지토리에 저장
        return member.getId(); // 멤버 아이디를 리턴
    }

    private void validateDuplicateMember(Member member){ //중복 회원 검증
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne((memberId));
    }




}
