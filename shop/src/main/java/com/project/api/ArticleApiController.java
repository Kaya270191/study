package com.project.api;

import com.project.dto.ArticleForm;
import com.project.entity.Article;
import com.project.repository.ArticleRepository;
import com.project.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController //RestAPI 용 컨트롤러! 데이터(JSON)를 반환
public class ArticleApiController {

    @Autowired //DI, 생성 객체를 가져와 연결
    private ArticleService articleService;

//    @Autowired //DI  (외부에서 가져온다)
//    private ArticleRepository articleRepository;
//
//    //GET
//    @GetMapping("/api/articles")
//    public List<Article> index(){
//        return articleRepository.findAll();
//    }

    //GET
    @GetMapping("/api/articles")
    public List<Article> index(){ //전체 목록 조회
        return articleService.index();
    }

//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id){
//        return articleRepository.findById(id).orElse(null);
//    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) { //단건 조회
        return articleService.show(id);
    }
//
//    //POST
//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){ //requestbody 부분의 JSON을 ArticleForm 에다가 가져옴
//        Article article = dto.toEntity();
//        return articleRepository.save(article); //클라이언트가 보내준 article을 DB에 저장
//    }

    //POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){ //requestbody 부분의 JSON을 ArticleForm 에다가 가져옴
        Article created = articleService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



//
//    //PATCH
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
//
//        //1: 수정용 엔티티 생성
//        Article article = dto.toEntity();
//        log.info("id: {} , article: {}", id, article.toString()); //{} {}에  id, article 이 순서대로 들어감
//
//        //2: 대상 엔티티 조회
//        Article target = articleRepository.findById(id).orElse(null);
//
//        //3: 잘못된 요청 처리(대상이 없거나 id가 다른 경우)
//        if (target == null || id != article.getId()){
//            //400, 잘못된 요청 응답!
//            log.info("잘못된 요청 id: {} , article: {}", id, article.toString()); //{} {}에  id, article 이 순서대로 들어감
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        //4: 업데이트 및 정상 응답(200)
//        target.patch(article);
//        Article updated = articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }


    //PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        Article updated = articleService.update(id, dto);
        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//
//
//    //DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id){
//        // 1: 대상 찾기
//        Article target = articleRepository.findById(id).orElse(null);
//
//        // 2: 잘못된 요청 처리
//        if(target == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 3: 대상 삭제
//        articleRepository.delete(target);
//
//        // 4: 데이터 반환
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    //DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);
        return (deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //트랜잭션 -> 실패 -> 롤백!
    @PostMapping("api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos){
        List<Article> createdList= articleService.createArticles(dtos);
        return (createdList != null) ? ResponseEntity.status(HttpStatus.OK).body(createdList) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
