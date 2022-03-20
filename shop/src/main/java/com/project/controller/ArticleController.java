package com.project.controller;

import com.project.dto.ArticleForm;
import com.project.entity.Article;
import com.project.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new") // localhost:8030/articles/new 가 들어오면
    public String newArticleForm(){
        return "/articles/new"; //templates/articles/new 파일이 있음
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) { //폼데이터로 받은 것이 파라매터로 들어옴
        log.info(form.toString());
//        System.out.println(form.toString()); --> 로깅 기능으로 대체

        //1. Dto 를 변환 -> Entity
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println(article.toString());

        //2. Repository에게 Entity를 DB안에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println(saved.toString());

        return "redirect:/articles/" + saved.getId(); // 쓴 글의 제목과 내용을 보여주는 페이지로
    }
    
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){ //{id}로 부터 받은 것
        log.info("id = " + id);

        //1: id로 데이터를 가져옴
        Article articleEntity = (Article) articleRepository.findAllById(id); //리파지토리에서 id값으로 찾고 없으면 null로 반환해라.orElse(null)s

        //2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        //3: 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")  // 해당 url 을 받으면 메소드가 실행
    public String index(Model model){
        //1:  모든 Article을 가져온다
        List<Article> ArticleEntityList=  articleRepository.findAll();
//        Iterable<Article> ArticleEntityList=  articleRepository.findAll(); Iternable 타입으로 해도됨

        //2: 가져온 Article 묶음을 뷰로 전달
        model.addAttribute("articleList", ArticleEntityList);

        //3: 뷰 페이지를 설정
        return "articles/index"; //뷰 페이지 articles/index.mustache
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){ //url path에서 id를 가져온다
        // 1: 수정할 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2: 모델에 데이터를 등록
        model.addAttribute("article", articleEntity);

        //3: 뷰페이지 설정
        return "articles/edit"; //수정페이지를 반환
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){ //dto를 받아옴 
        log.info(form.toString());

        //1: DTO를 엔티티로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        //2. 엔티티를 DB로 저장
        //2-1 : DB에 기존 데이터를 가져온다
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        //2-2: 기존 데이터에 값을 갱신한다
        if(target != null){ //가져올 데이터가 있으면 갱신한다
            articleRepository.save(articleEntity); //엔티티가 DB로 갱신
        }

        //3: 수정 결과 페이지로 리다이렉트 한다
        return "redirect:/articles/" + articleEntity.getId();
    }

    //삭제
    @GetMapping("/articles/{id}/delete") //deletemapping 이여야 하지만 getmapping 으로 받음
    public String delete(@PathVariable Long id, RedirectAttributes rttr){ //url path에서 id를 가져온다. RedirectAttributes 는 삭제시에 메시지 띄어주려고
        log.info("삭제 요청이 들어왔습니다!");

        //1: 삭제 대상을 가져온다
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        //2: 대상을 DB 에서 삭제한다
        if (target != null){
            articleRepository.delete(target); //리파지토리가 제공하는 delete 메소드를 사용해서 삭제 
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다"); //articles 페이지에 메시지가 뜸
        }

        //3: 결과 페이지로 리다이렉트 한다
        return "redirect:/articles"; // 목록으로 리다이렉트
    }


}
