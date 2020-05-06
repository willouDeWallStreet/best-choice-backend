package com.william.evrard.bestchoicebackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.william.evrard.bestchoicebackend.model.entity.Topic;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopicDto {

    private Long noTopic;
    private String lbTopic;

    public TopicDto() {
    }

    public TopicDto(Topic pEntity) {
        this(pEntity, false, false);
    }

    public TopicDto(Topic pEntity, boolean pIncludeOneToOne, boolean pIncludeOneToMany) {
        this.noTopic = pEntity.getNoTopic();
        this.lbTopic = pEntity.getLbTopic();
    }

    public TopicDto(Long noTopic, String lbTopic) {
        this.noTopic = noTopic;
        this.lbTopic = lbTopic;
    }

    public Long getNoTopic() {
        return noTopic;
    }

    public void setNoTopic(Long noTopic) {
        this.noTopic = noTopic;
    }

    public String getLbTopic() {
        return lbTopic;
    }

    public void setLbTopic(String lbTopic) {
        this.lbTopic = lbTopic;
    }
}
