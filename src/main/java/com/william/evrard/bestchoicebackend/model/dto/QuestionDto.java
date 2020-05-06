package com.william.evrard.bestchoicebackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.william.evrard.bestchoicebackend.model.entity.Answer;
import com.william.evrard.bestchoicebackend.model.entity.Question;
import com.william.evrard.bestchoicebackend.model.entity.Topic;
import com.william.evrard.bestchoicebackend.utils.Utils;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {

    private Long noQuestion;
    private Integer nrQuestion;
    private String lbQuestion;
    private TopicDto topicByNoTopic;
    private Set<AnswerDto> answerListByNoanswer;

    public QuestionDto() {
    }

    public QuestionDto(Question pEntity) {
        this(pEntity, false, false);
    }

    public QuestionDto(Question pEntity, boolean pIncludeOneToOne, boolean pIncludeOneToMany) {
        this.noQuestion = pEntity.getNoQuestion();
        this.nrQuestion = pEntity.getNrQuestion();
        this.lbQuestion = pEntity.getLbQuestion();
        if (pIncludeOneToOne && pEntity.getTopicByNoTopic() != null) {
            this.topicByNoTopic = new TopicDto(pEntity.getTopicByNoTopic());
        }
        if (pIncludeOneToMany && Utils.isNullOrEmpty(pEntity.getAnswerListByNoanswer())) {
            Set<AnswerDto> dtoSet = new HashSet<>(Utils.getSizeOrZero(pEntity.getAnswerListByNoanswer()));
            for (Answer entity : pEntity.getAnswerListByNoanswer()) {
                dtoSet.add(new AnswerDto(entity));
            }
            answerListByNoanswer = dtoSet;
        }
    }

    public QuestionDto(Long noQuestion, Integer nrQuestion, String lbQuestion, TopicDto topicByNoTopic) {
        this.noQuestion = noQuestion;
        this.nrQuestion = nrQuestion;
        this.lbQuestion = lbQuestion;
        this.topicByNoTopic = topicByNoTopic;
    }

    public Long getNoQuestion() {
        return noQuestion;
    }

    public void setNoQuestion(Long noQuestion) {
        this.noQuestion = noQuestion;
    }

    public Integer getNrQuestion() {
        return nrQuestion;
    }

    public void setNrQuestion(Integer nrQuestion) {
        this.nrQuestion = nrQuestion;
    }

    public String getLbQuestion() {
        return lbQuestion;
    }

    public void setLbQuestion(String lbQuestion) {
        this.lbQuestion = lbQuestion;
    }

    public TopicDto getTopicByNoTopic() {
        return topicByNoTopic;
    }

    public void setTopicByNoTopic(TopicDto topicByNoTopic) {
        this.topicByNoTopic = topicByNoTopic;
    }

    public Set<AnswerDto> getAnswerListByNoanswer() {
        return answerListByNoanswer;
    }

    public void setAnswerListByNoanswer(Set<AnswerDto> answerListByNoanswer) {
        this.answerListByNoanswer = answerListByNoanswer;
    }
}
