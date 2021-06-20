package com.apicard.rest.service;

import com.apicard.domain.entity.Pergunta;
import com.apicard.domain.entity.Resposta;
import com.apicard.rest.dto.PerguntaDTO;
import io.vertx.core.json.JsonObject;
import org.apache.http.HttpStatus;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

public class PerguntaService {
    public static PerguntaDTO gerarPergunta(String categoria) {
        if (categoria != null) {

            Pergunta pergunta;

            List<Pergunta> perguntas = Pergunta.find("categoria", categoria).list();
            if (perguntas.size() != 0) {

                Random random = new Random();
                int aleatorio = random.nextInt(perguntas.size());
                pergunta = perguntas.get(aleatorio);

                List<Resposta> respostas = Resposta.find("id_pergunta", pergunta.id).list();
                PerguntaDTO perguntaDTO = new PerguntaDTO();
                perguntaDTO.categoria = categoria;
                perguntaDTO.pergunta = pergunta.pergunta;
                perguntaDTO.respostas = respostas;

                return perguntaDTO;
            } else {
                throw new WebApplicationException(Response.status(HttpStatus.SC_NOT_FOUND).entity(new JsonObject().put("error", "Categoria inválida")).build());
            }
        } else {
            throw new WebApplicationException(Response.status(HttpStatus.SC_NOT_FOUND).entity(new JsonObject().put("error", "Preencha a categoria.")).build());
        }
    }
}
