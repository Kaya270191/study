package com.project.api;

import com.project.domain.Board;
import com.project.dto.BoardForm;
import com.project.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Slf4j
@RestController
public class BoardApiController {

    @Autowired //스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연결
    private BoardService boardService;

    //GET
    @GetMapping("/api/boards")  //게시글 리스트 보여줌
    public List<Board> index(){
        return boardService.index();
    }

    @GetMapping("/api/boards/{id}")
    public Board show(@PathVariable Long id) {
             return boardService.show(id);
    }

    //POST
    @PostMapping("/api/boards")
    public ResponseEntity<Board> create(@RequestBody BoardForm dto){
        Board created = boardService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //PATCH
    @PatchMapping("api/boards/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody BoardForm dto){
        Board updated = boardService.update(id, dto);
        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //DELETE
    @DeleteMapping("/api/boards/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Board deleted = boardService.delete(id);
        return (deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
