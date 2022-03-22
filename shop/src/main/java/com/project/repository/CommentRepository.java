package com.project.repository;


import com.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //특정 게시글의 모든 댓글 조회

    // 어노테이션 기반 SQL 조회: 특정 게시글(article)의 모든 댓글(comment)
    @Query(value =
            "SELECT * " +
                    "FROM comment " +
                    "WHERE article_id = :articleId",
            nativeQuery = true)
    List<Comment> findByArticleId(Long articleId);


    //xml 기반 SQL 조회: 특정 닉네임의 모든 댓글 조회 -- /resources/META_INF/orm.xml 파일로 작성해봄
    List<Comment> findByNickname(String nickname);

}
