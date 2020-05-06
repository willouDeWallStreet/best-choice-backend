package com.william.evrard.bestchoicebackend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParametreSimpleDto {
    private Long noPar;
    private Integer intPar;

    public ParametreSimpleDto() {
    }

    public ParametreSimpleDto(Long pNoPar, Integer pNoInt) {
        this.noPar = pNoPar;
        this.intPar = pNoInt;
    }

    public Long getNoPar() {
        return noPar;
    }

    public void setNoPar(Long noPar) {
        this.noPar = noPar;
    }

    public Integer getIntPar() {
        return intPar;
    }

    public void setIntPar(Integer intPar) {
        this.intPar = intPar;
    }
}
