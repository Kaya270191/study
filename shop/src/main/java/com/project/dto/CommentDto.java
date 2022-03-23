package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long id; //코멘트의 아이디

    @JsonProperty("article_id")
    private Long articleId; //코멘트가 포함된 게시글의 아이디
    private String nickName;
    private String body;


    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody());
    }
}