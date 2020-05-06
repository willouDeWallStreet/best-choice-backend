package com.william.evrard.bestchoicebackend.utils;

import com.william.evrard.bestchoicebackend.model.dto.AnswerDto;
import com.william.evrard.bestchoicebackend.model.dto.ParametreSimpleDto;
import com.william.evrard.bestchoicebackend.model.entity.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnswerUtils {

    public static List<AnswerDto> buildDtoList(List<Answer> pEntityList) {
        List<AnswerDto> dtoList = new ArrayList<>();
        for(Answer entity : pEntityList) {
            dtoList.add(new AnswerDto(entity));
        }
        return dtoList;
    }

    public static List<ParametreSimpleDto> buildParamSimpleDtoFromAnswerList(List<Answer> pEntityList) {
        List<ParametreSimpleDto> parametreSimpleDtoList = new ArrayList<>();
        for(Answer entity : pEntityList) {
            parametreSimpleDtoList.add(new ParametreSimpleDto(entity.getNoAnswer(), entity.getCounting()));
        }
        return parametreSimpleDtoList;
    }
}
