package com.senai.techdivem3exercicios.controller;


import com.senai.techdivem3exercicios.dto.InscricaoReqDTO;
import com.senai.techdivem3exercicios.dto.InscricaoRespDTO;
import com.senai.techdivem3exercicios.mapper.InscricaoMapper;
import com.senai.techdivem3exercicios.model.Inscricao;
import com.senai.techdivem3exercicios.service.InscricoesService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Path("/inscricoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InscricoesController {

    @Inject
    private InscricoesService service;

    @POST
    public Response inserir(@Valid InscricaoReqDTO inscricaoReqDto) {
        Inscricao inscricao = InscricaoMapper.INSTANCE.toModel(inscricaoReqDto);
        inscricao = service.inserir(inscricao);
        InscricaoRespDTO resp = InscricaoMapper.INSTANCE.toResponse(inscricao);
        return Response.created(URI.create(resp.getId().toString())).entity(resp).build();
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") Integer id) {
        service.excluir(id);
        return Response.noContent().build();
    }

    @GET
    public Response obter() {
        List<Inscricao> inscricoes = service.obter();
        List<InscricaoRespDTO> resp = inscricoes.stream().map(InscricaoMapper.INSTANCE::toResponse).collect(Collectors.toList());
        return Response.ok(resp).build();
    }

}
