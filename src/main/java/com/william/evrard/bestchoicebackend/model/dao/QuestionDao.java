package com.william.evrard.bestchoicebackend.model.dao;

import com.william.evrard.bestchoicebackend.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Long> {
    List<Question> findByTopicByNoTopic_NoTopicOrderByNrQuestionAsc(Long pNoTopic);
}
