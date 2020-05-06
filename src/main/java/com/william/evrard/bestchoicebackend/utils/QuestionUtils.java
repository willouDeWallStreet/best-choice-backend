package com.william.evrard.bestchoicebackend.utils;

import com.william.evrard.bestchoicebackend.model.dto.QuestionDto;
import com.william.evrard.bestchoicebackend.model.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QuestionUtils {

    public static List<QuestionDto> buildDtoList(List<Question> pEntityList) {
        List<QuestionDto> dtoList = new ArrayList<>();
        for(Question entity : pEntityList) {
            dtoList.add(new QuestionDto(entity));
        }
        return dtoList;
    }

    public static List<QuestionDto> buildDtoList(Set<Question> pEntityList) {
        List<QuestionDto> dtoList = new ArrayList<>();
        for(Question entity : pEntityList) {
            dtoList.add(new QuestionDto(entity));
        }
        return dtoList;
    }
}
