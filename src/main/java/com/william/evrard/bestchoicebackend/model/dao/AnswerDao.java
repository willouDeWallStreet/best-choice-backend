package com.william.evrard.bestchoicebackend.model.dao;

import com.william.evrard.bestchoicebackend.model.entity.Answer;
import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnswerDao  extends JpaRepository<Answer, Long> {

    @Query("SELECT a from Answer a where a.questionByNoquestion.noQuestion = :noQuestion order by a.nrAnswer")
    List<Answer> findByNoQuestionOrderByNrAnswerAsc(@Param("noQuestion") Long pNoQuestion);

    @Transactional
    @Modifying
    @Query("update Answer a set a.counting = a.counting + 1 where a.noAnswer = :noAnswer")
    void upAnswerCounting(@Param("noAnswer") Long pNoAnswer) throws NotFoundException;
}
