package com.project.service;

import com.project.domain.Member;
import com.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    //회원가입

    public Long join(Member member){

        memberRepository.save(member);
        return member.getId();

    }

}
