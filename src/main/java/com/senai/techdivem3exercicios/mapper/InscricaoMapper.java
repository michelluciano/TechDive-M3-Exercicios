package com.senai.techdivem3exercicios.mapper;

import com.senai.techdivem3exercicios.dto.InscricaoReqDTO;
import com.senai.techdivem3exercicios.dto.InscricaoRespDTO;
import com.senai.techdivem3exercicios.model.Inscricao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InscricaoMapper {

    InscricaoMapper INSTANCE = Mappers.getMapper(InscricaoMapper.class);

    @Mapping(source = "aluno.matricula", target = "matriculaAluno")
    @Mapping(source = "curso.codigo", target = "codigoCurso")
    InscricaoReqDTO toRequest(Inscricao model);

    @Mapping(source = "matriculaAluno", target = "aluno.matricula")
    @Mapping(source = "codigoCurso", target = "curso.codigo")
    Inscricao toModel(InscricaoReqDTO request);

    @Mapping(source = "aluno.matricula", target = "matriculaAluno")
    @Mapping(source = "curso.codigo", target = "codigoCurso")
    InscricaoRespDTO toResponse(Inscricao model);

    @Mapping(source = "matriculaAluno", target = "aluno.matricula")
    @Mapping(source = "codigoCurso", target = "curso.codigo")
    Inscricao toModel(InscricaoRespDTO response);

}
