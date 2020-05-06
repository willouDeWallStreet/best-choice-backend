package com.william.evrard.bestchoicebackend.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    private long noAnswer;
    private int nrAnswer;
    private String lbAnswer;
    private Question questionByNoquestion;
    private int counting;
    //TODO WEV (2020/05/01)
    //private boolean goodAnswer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noanswer", nullable=false)
    public long getNoAnswer() {
        return noAnswer;
    }

    public void setNoAnswer(long noAnswer) {
        this.noAnswer = noAnswer;
    }

    @Column(name = "nranswer", nullable=false)
    public int getNrAnswer() {
        return nrAnswer;
    }

    public void setNrAnswer(int nrAnswer) {
        this.nrAnswer = nrAnswer;
    }

    @Column(name = "lbanswer", nullable=false, length = 128)
    public String getLbAnswer() {
        return lbAnswer;
    }

    public void setLbAnswer(String lbAnswer) {
        this.lbAnswer = lbAnswer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noquestion", nullable=false)
    public Question getQuestionByNoquestion() {
        return questionByNoquestion;
    }

    public void setQuestionByNoquestion(Question questionByNoquestion) {
        this.questionByNoquestion = questionByNoquestion;
    }

    @Column(name = "counting", nullable=false)
    public int getCounting() {
        return counting;
    }

    public void setCounting(int counting) {
        this.counting = counting;
    }
}
