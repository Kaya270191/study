package com.project.dto;

import com.project.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

//폼데이터가 던져주는 것을 받은 dto
@AllArgsConstructor //생성자 
@ToString //투스트링
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
