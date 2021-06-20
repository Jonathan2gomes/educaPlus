package com.apicard.rest.resource;

import com.apicard.domain.entity.Pergunta;
import com.apicard.rest.dto.PerguntaDTO;
import com.apicard.rest.service.PerguntaService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pergunta")
public class PerguntaResource {

    @GET
    @Operation(summary = "Lista todas as entidades corp cadastradas")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Lista de perguntas cadastradas",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Pergunta.class)))
    })
    public List<Pergunta> listarEntidades() {
        return Pergunta.listAll();
    }

    @GET
    @Path("/pergunta")
    @Operation(summary = "Lista todas as entidades corp cadastradas")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Lista de perguntas cadastradas",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Pergunta.class)))
    })
    public PerguntaDTO pergunta(@HeaderParam("categoria")String categoria) {
        try {
            return PerguntaService.gerarPergunta(categoria);
        } catch (Exception e) {
            throw e;
        }
    }
}
