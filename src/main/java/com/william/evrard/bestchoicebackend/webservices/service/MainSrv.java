package com.william.evrard.bestchoicebackend.webservices.service;

import com.william.evrard.bestchoicebackend.model.dao.AnswerDao;
import com.william.evrard.bestchoicebackend.model.dao.QuestionDao;
import com.william.evrard.bestchoicebackend.model.dao.TopicDao;
import com.william.evrard.bestchoicebackend.model.dto.AnswerDto;
import com.william.evrard.bestchoicebackend.model.dto.ParametreSimpleDto;
import com.william.evrard.bestchoicebackend.model.dto.QuestionDto;
import com.william.evrard.bestchoicebackend.model.dto.TopicDto;
import com.william.evrard.bestchoicebackend.model.entity.Answer;
import com.william.evrard.bestchoicebackend.model.entity.Question;
import com.william.evrard.bestchoicebackend.model.entity.Topic;
import com.william.evrard.bestchoicebackend.utils.AnswerUtils;
import com.william.evrard.bestchoicebackend.utils.QuestionUtils;
import com.william.evrard.bestchoicebackend.utils.TopicUtils;
import com.william.evrard.bestchoicebackend.utils.Utils;
import com.william.evrard.bestchoicebackend.webservices.exception.CustomApiException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainSrv {

    @Autowired
    private TopicDao topicDao;
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private AnswerDao answerDao;

    /************************** Topic *******************************/
    public List<TopicDto> getTopicList() {
        return TopicUtils.buildDtoList(topicDao.findAll());
    }


    /************************** Question *******************************/
    public List<QuestionDto> getQuestionListByNotopic(Long pNoTopic) {
        return QuestionUtils.buildDtoList(questionDao.findByTopicByNoTopic_NoTopicOrderByNrQuestionAsc(pNoTopic));
    }

    /************************** Answer *******************************/
    public List<AnswerDto> getAnswerListByNoquestion(Long pNoQuestion) {
        return AnswerUtils.buildDtoList(answerDao.findByNoQuestionOrderByNrAnswerAsc(pNoQuestion));
    }

    public List<AnswerDto> upAnswerCounting(Long pNoAnswer) throws CustomApiException {
        try {
            answerDao.upAnswerCounting(pNoAnswer);
            Answer answer = answerDao.findById(pNoAnswer).orElseThrow(() -> new CustomApiException(HttpStatus.NOT_FOUND));
            return getAnswerListByNoquestion(answer.getQuestionByNoquestion().getNoQuestion());
        } catch (NotFoundException nfe) {
            throw new CustomApiException(HttpStatus.NOT_FOUND);
        }
    }
}
