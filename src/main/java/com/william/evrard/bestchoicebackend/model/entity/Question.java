package com.william.evrard.bestchoicebackend.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    private long noQuestion;
    private int nrQuestion;
    private String lbQuestion;
    private Topic topicByNoTopic;
    private Set<Answer> answerListByNoanswer;
    //TODO WEV (2020/05/01)
    //private QuestionType questionType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noquestion", nullable=false)
    public long getNoQuestion() {
        return noQuestion;
    }

    public void setNoQuestion(long noQuestion) {
        this.noQuestion = noQuestion;
    }

    @Column(name = "nrquestion", nullable=false)
    public int getNrQuestion() {
        return nrQuestion;
    }

    public void setNrQuestion(int nrQuestion) {
        this.nrQuestion = nrQuestion;
    }

    @Column(name = "lbquestion", nullable=false, length = 128)
    public String getLbQuestion() {
        return lbQuestion;
    }

    public void setLbQuestion(String lbQuestion) {
        this.lbQuestion = lbQuestion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notopic", nullable=false)
    public Topic getTopicByNoTopic() {
        return topicByNoTopic;
    }

    public void setTopicByNoTopic(Topic topicByNoTopic) {
        this.topicByNoTopic = topicByNoTopic;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionByNoquestion")
    public Set<Answer> getAnswerListByNoanswer() {
        return answerListByNoanswer;
    }

    public void setAnswerListByNoanswer(Set<Answer> answerListByNoanswer) {
        this.answerListByNoanswer = answerListByNoanswer;
    }
}
