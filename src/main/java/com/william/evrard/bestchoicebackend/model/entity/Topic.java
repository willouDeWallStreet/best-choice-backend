package com.william.evrard.bestchoicebackend.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic {

    private long noTopic;
    private String lbTopic;
    private Set<Question> questionListByNoquestion;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notopic", nullable=false)
    public long getNoTopic() {
        return noTopic;
    }

    public void setNoTopic(long noTopic) {
        this.noTopic = noTopic;
    }

    @Column(name = "lbtopic", nullable=false, length = 64)
    public String getLbTopic() {
        return lbTopic;
    }

    public void setLbTopic(String lbTopic) {
        this.lbTopic = lbTopic;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topicByNoTopic")
    public Set<Question> getQuestionListByNoquestion() {
        return questionListByNoquestion;
    }

    public void setQuestionListByNoquestion(Set<Question> questionListByNoquestion) {
        this.questionListByNoquestion = questionListByNoquestion;
    }
}
