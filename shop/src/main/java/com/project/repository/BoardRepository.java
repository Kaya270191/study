package com.project.repository;

import com.project.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.ArrayList;

public interface BoardRepository extends JpaRepository<Board, Long> {


    Object findAllById(Long id);

    @Override
    ArrayList<Board> findAll();

    @Modifying
    @Query("update Board b set b.view_count = b.view_count + 1 where b.id =:id")
    int updateView(Long id);
}
