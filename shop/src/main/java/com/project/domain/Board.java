package com.project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //게시글 번호

    @Column
    private String title; //제목

    @Column
    private String writer; //작성자

    private String content; //내용
    private int view_count; //조회수
    private Date reg_date; //게시글 작성일자
}
