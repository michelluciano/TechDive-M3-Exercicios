package com.senai.techdivem3exercicios.mapper;

import com.senai.techdivem3exercicios.dto.AlunoDTO;
import com.senai.techdivem3exercicios.model.Aluno;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-04T20:50:02-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
public class AlunoMapperImpl implements AlunoMapper {

    @Override
    public AlunoDTO toDTO(Aluno model) {
        if ( model == null ) {
            return null;
        }

        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setMatricula( model.getMatricula() );
        alunoDTO.setNome( model.getNome() );

        return alunoDTO;
    }

    @Override
    public Aluno toModel(AlunoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setMatricula( dto.getMatricula() );
        aluno.setNome( dto.getNome() );

        return aluno;
    }
}
