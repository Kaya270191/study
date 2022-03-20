package com.project.dto;

import com.project.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

//폼데이터가 던져주는 것을 받은 dto
@AllArgsConstructor //생성자 
@ToString //투스트링
public class ArticleForm {

    private Long id; //update 위해 id 필드 추가
    private String title;
    private String content;

    //id 필드 추가로 인한 toEntity() 코드변경
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
