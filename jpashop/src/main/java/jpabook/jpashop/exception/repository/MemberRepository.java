package jpabook.jpashop.exception.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

//회원 리포지토리 개발
@Repository //리포지토리 스프링빈에 등록
@RequiredArgsConstructor
public class MemberRepository {


    private final EntityManager em;

    public void save(Member member){
        em.persist(member); //엔티티 매니저가 영속성 컨텍스트에 멤버 객체 넣음-> 트랜잭션이 커밋되는 순간 디비에 인서트쿼리가 날아감
    }

    public Member findOne(Long id){ //JPA의 find매서드 사용: 단건 조회
        return em.find(Member.class, id);  //find(타입, pk)
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) //from의 대상이 엔티티임
                .getResultList();
    }

    public List<Member> findByName(String name){ //파라미터 바인딩. 특정 이름 회원만 찾기
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
