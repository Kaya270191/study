package com.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity //DB가 해당 객체를 인식 가능(해당 클래스로 테이블을 만든다)
@AllArgsConstructor //생성자
@ToString //투스트링
@NoArgsConstructor //디폴트 생성자
@Getter
public class Article {

    @Id //대표값을 지정 like 주민등록 번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id를 자동생성함 .1,2,3...자동 생성 어노테이션
    private Long id; //대표값

    @Column //테이블 안 컬럼
    private String title;

    @Column
    private String content;


}
