package com.apicard.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "resposta")
public class Resposta extends PanacheEntity {
    
    @Column(name = "descricao")
    public String descricaoResposta;
    
    @Column(name = "resposta_correta")
    public Boolean respostaCerta;

    @Column(name = "id_pergunta")
    public String idPergunta;

    public Resposta() {
    }

    public Resposta(String descricaoResposta, Boolean respostaCerta) {
        this.descricaoResposta = descricaoResposta;
        this.respostaCerta = respostaCerta;
    }

    public Resposta buscaRespostaCorreta() {
        return find("resposta_correta", true).firstResult();
    }
}
