package com.william.evrard.bestchoicebackend.model.dao;

import com.william.evrard.bestchoicebackend.model.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicDao extends JpaRepository<Topic, Long> {
}
