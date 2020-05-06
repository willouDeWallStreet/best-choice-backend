package com.william.evrard.bestchoicebackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.william.evrard.bestchoicebackend.model.entity.Answer;
import com.william.evrard.bestchoicebackend.model.entity.Question;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDto {

    private Long noAnswer;
    private Integer nrAnswer;
    private String lbAnswer;
    private QuestionDto questionByNoquestion;
    private Integer counting;

    public AnswerDto() {
    }

    public AnswerDto(Answer pEntity) {
        this(pEntity, false, false);
    }

    public AnswerDto(Answer pEntity, boolean pIncludeOneToOne, boolean pIncludeOneToMany) {
        this.noAnswer = pEntity.getNoAnswer();
        this.nrAnswer = pEntity.getNrAnswer();
        this.lbAnswer = pEntity.getLbAnswer();
        if (pIncludeOneToOne && pEntity.getQuestionByNoquestion() != null) {
            this.questionByNoquestion = new QuestionDto(pEntity.getQuestionByNoquestion());
        }
        this.counting = pEntity.getCounting();
    }

    public AnswerDto(Long noAnswer, Integer nrAnswer, String lbAnswer, QuestionDto questionByNoquestion, Integer counting) {
        this.noAnswer = noAnswer;
        this.nrAnswer = nrAnswer;
        this.lbAnswer = lbAnswer;
        this.questionByNoquestion = questionByNoquestion;
        this.counting = counting;
    }

    public Long getNoAnswer() {
        return noAnswer;
    }

    public void setNoAnswer(Long noAnswer) {
        this.noAnswer = noAnswer;
    }

    public Integer getNrAnswer() {
        return nrAnswer;
    }

    public void setNrAnswer(Integer nrAnswer) {
        this.nrAnswer = nrAnswer;
    }

    public String getLbAnswer() {
        return lbAnswer;
    }

    public void setLbAnswer(String lbAnswer) {
        this.lbAnswer = lbAnswer;
    }

    public QuestionDto getQuestionByNoquestion() {
        return questionByNoquestion;
    }

    public void setQuestionByNoquestion(QuestionDto questionByNoquestion) {
        this.questionByNoquestion = questionByNoquestion;
    }

    public int getCounting() {
        return counting;
    }

    public void setCounting(int counting) {
        this.counting = counting;
    }
}
