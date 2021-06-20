package com.apicard.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pergunta")
public class Pergunta extends PanacheEntityBase {

    @Id
    public String id;
    
    @Column
    public String categoria;
    
    @Column
    public String pergunta;

    public Pergunta() {
    }

}

