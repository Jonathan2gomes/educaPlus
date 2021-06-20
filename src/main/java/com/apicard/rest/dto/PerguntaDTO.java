package com.apicard.rest.dto;

import com.apicard.domain.entity.Resposta;

import java.util.List;

public class PerguntaDTO {

    public String categoria;

    public String pergunta;

    public List<Resposta> respostas;

    public PerguntaDTO(){
    }
}
