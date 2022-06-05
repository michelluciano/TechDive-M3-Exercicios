package com.senai.techdivem3exercicios.mapper;

import com.senai.techdivem3exercicios.dto.InscricaoReqDTO;
import com.senai.techdivem3exercicios.dto.InscricaoRespDTO;
import com.senai.techdivem3exercicios.model.Aluno;
import com.senai.techdivem3exercicios.model.Curso;
import com.senai.techdivem3exercicios.model.Inscricao;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-04T20:50:02-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
public class InscricaoMapperImpl implements InscricaoMapper {

    @Override
    public InscricaoReqDTO toRequest(Inscricao model) {
        if ( model == null ) {
            return null;
        }

        InscricaoReqDTO inscricaoReqDTO = new InscricaoReqDTO();

        inscricaoReqDTO.setMatriculaAluno( modelAlunoMatricula( model ) );
        inscricaoReqDTO.setCodigoCurso( modelCursoCodigo( model ) );

        return inscricaoReqDTO;
    }

    @Override
    public Inscricao toModel(InscricaoReqDTO request) {
        if ( request == null ) {
            return null;
        }

        Inscricao inscricao = new Inscricao();

        inscricao.setAluno( inscricaoReqDTOToAluno( request ) );
        inscricao.setCurso( inscricaoReqDTOToCurso( request ) );

        return inscricao;
    }

    @Override
    public InscricaoRespDTO toResponse(Inscricao model) {
        if ( model == null ) {
            return null;
        }

        InscricaoRespDTO inscricaoRespDTO = new InscricaoRespDTO();

        inscricaoRespDTO.setMatriculaAluno( modelAlunoMatricula( model ) );
        inscricaoRespDTO.setCodigoCurso( modelCursoCodigo( model ) );
        inscricaoRespDTO.setId( model.getId() );

        return inscricaoRespDTO;
    }

    @Override
    public Inscricao toModel(InscricaoRespDTO response) {
        if ( response == null ) {
            return null;
        }

        Inscricao inscricao = new Inscricao();

        inscricao.setAluno( inscricaoRespDTOToAluno( response ) );
        inscricao.setCurso( inscricaoRespDTOToCurso( response ) );
        inscricao.setId( response.getId() );

        return inscricao;
    }

    private Integer modelAlunoMatricula(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }
        Aluno aluno = inscricao.getAluno();
        if ( aluno == null ) {
            return null;
        }
        Integer matricula = aluno.getMatricula();
        if ( matricula == null ) {
            return null;
        }
        return matricula;
    }

    private String modelCursoCodigo(Inscricao inscricao) {
        if ( inscricao == null ) {
            return null;
        }
        Curso curso = inscricao.getCurso();
        if ( curso == null ) {
            return null;
        }
        String codigo = curso.getCodigo();
        if ( codigo == null ) {
            return null;
        }
        return codigo;
    }

    protected Aluno inscricaoReqDTOToAluno(InscricaoReqDTO inscricaoReqDTO) {
        if ( inscricaoReqDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setMatricula( inscricaoReqDTO.getMatriculaAluno() );

        return aluno;
    }

    protected Curso inscricaoReqDTOToCurso(InscricaoReqDTO inscricaoReqDTO) {
        if ( inscricaoReqDTO == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setCodigo( inscricaoReqDTO.getCodigoCurso() );

        return curso;
    }

    protected Aluno inscricaoRespDTOToAluno(InscricaoRespDTO inscricaoRespDTO) {
        if ( inscricaoRespDTO == null ) {
            return null;
        }

        Aluno aluno = new Aluno();

        aluno.setMatricula( inscricaoRespDTO.getMatriculaAluno() );

        return aluno;
    }

    protected Curso inscricaoRespDTOToCurso(InscricaoRespDTO inscricaoRespDTO) {
        if ( inscricaoRespDTO == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setCodigo( inscricaoRespDTO.getCodigoCurso() );

        return curso;
    }
}
