package com.project.service;

import com.project.dto.ArticleForm;
import com.project.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //해당 클래스는 스프링부트와 연동되어 테스팅된다
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공____존재하는_id_입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패____존재하지_않는_id_입력() {
        //예상
        Long id = -1L;
        Article expected = null;
        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected, article); // 둘다 null
    }

    @Test
    @Transactional  //테스트 종료 후 변경된 데이터를 롤백(처음으로 되돌림)처리
    void create_성공_title과_content만_있는_dto입력() {
        //예상
        String title ="라라라라";
        String content ="4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(1L, title, content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());

    }

    @Test
    @Transactional
    void create_실패__id가_포함된_dto_입력() {
        //예상
        String title ="라라라라";
        String content ="4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void update_성공____존재하는_id와_title_content가_있는_dto_입력() {
    }
    @Test
    @Transactional
    void update_성공____존재하는_id와_title만_있는_dto_입력() {
    }
    @Test
    @Transactional
    void update_실패____존재하지_않는_id_의_dto_입력() {
    }
}