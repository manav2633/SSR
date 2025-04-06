package com.example.app.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.demo.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}