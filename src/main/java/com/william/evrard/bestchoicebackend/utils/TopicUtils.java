package com.william.evrard.bestchoicebackend.utils;

import com.william.evrard.bestchoicebackend.model.dto.TopicDto;
import com.william.evrard.bestchoicebackend.model.entity.Topic;

import java.util.ArrayList;
import java.util.List;

public class TopicUtils {

    public static List<TopicDto> buildDtoList(List<Topic> pEntityList) {
        List<TopicDto> dtoList = new ArrayList<>();
        for(Topic entity : pEntityList) {
            dtoList.add(new TopicDto(entity));
        }
        return dtoList;
    }
}
