package com.project.repository;

import com.project.domain.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Long> {


    Object findAllById(Long id);

    @Override
    ArrayList<Board> findAll();
}
