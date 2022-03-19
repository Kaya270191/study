package com.project.repository;

import com.project.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {


    Object findAllById(Long id);

    @Override
    ArrayList<Article> findAll();
}
