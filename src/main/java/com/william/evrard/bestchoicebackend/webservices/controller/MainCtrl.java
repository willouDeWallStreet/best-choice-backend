package com.william.evrard.bestchoicebackend.webservices.controller;

import com.william.evrard.bestchoicebackend.model.dto.ParametreSimpleDto;
import com.william.evrard.bestchoicebackend.webservices.exception.CustomApiException;
import com.william.evrard.bestchoicebackend.webservices.service.MainSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/best-choice")
public class MainCtrl {

    @Autowired
    private MainSrv mainSrv;

    /******************** Topic *************************/
    @PostMapping("/topic-list")
    public ResponseEntity getTopicList() {
        return ResponseEntity.ok(mainSrv.getTopicList());
    }

    /******************** Question *************************/
    @PostMapping("/question-list-by-notopic")
    public ResponseEntity getQuestionListByNotopic(@RequestBody ParametreSimpleDto pParametreSimpleDto) {
        return ResponseEntity.ok(mainSrv.getQuestionListByNotopic(pParametreSimpleDto.getNoPar()));
    }

    /******************** Answer *************************/
    @PostMapping("/answer-list-by-noquestion")
    public ResponseEntity getAnswerListByNoquestion(@RequestBody ParametreSimpleDto pParametreSimpleDto) {
        return ResponseEntity.ok(mainSrv.getAnswerListByNoquestion(pParametreSimpleDto.getNoPar()));
    }

    @PostMapping("/up-answer-counting")
    public ResponseEntity upAnswerCounting(@RequestBody ParametreSimpleDto pParametreSimpleDto) throws CustomApiException {
        return ResponseEntity.ok(mainSrv.upAnswerCounting(pParametreSimpleDto.getNoPar()));
    }


}
