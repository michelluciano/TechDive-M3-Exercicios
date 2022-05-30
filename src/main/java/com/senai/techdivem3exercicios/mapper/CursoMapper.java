package com.senai.techdivem3exercicios.mapper;

import com.senai.techdivem3exercicios.dto.CursoDTO;
import com.senai.techdivem3exercicios.model.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {

    CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    @Mapping(source = "duracao", target = "duracaoEmDias")
    CursoDTO toDTO(Curso model);

    @Mapping(source = "duracaoEmDias", target = "duracao")
    Curso toModel(CursoDTO dto);

}
