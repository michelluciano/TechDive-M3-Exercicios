package com.senai.techdivem3exercicios.mapper;

import com.senai.techdivem3exercicios.dto.AlunoDTO;
import com.senai.techdivem3exercicios.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlunoMapper {

    AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    AlunoDTO toDTO(Aluno model);

    Aluno toModel(AlunoDTO dto);

}