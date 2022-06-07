package com.senai.techdivem3exercicios.controller;

import com.senai.techdivem3exercicios.dto.AlunoDTO;
import com.senai.techdivem3exercicios.exception.RegistroExistenteException;
import com.senai.techdivem3exercicios.mapper.AlunoMapper;
import com.senai.techdivem3exercicios.model.Aluno;
import com.senai.techdivem3exercicios.service.AlunosService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlunoControllerTest {

    @Mock
    private AlunosService service;

    @InjectMocks
    private AlunoController controller;

    @Test
    @DisplayName("Quando aluno existente deve lançar exeção")
    void inserir_falhaexistente() {
        AlunoDTO alunoDTO = new AlunoDTO(1234,"nome do aluno");
        Aluno aluno = AlunoMapper.INSTANCE.toModel(alunoDTO);
        Mockito.doThrow(new RegistroExistenteException("Aluno", alunoDTO.getMatricula().toString())).when(service).inserir(Mockito.any(Aluno.class));
        assertThrows(RegistroExistenteException.class, () -> controller.inserir(alunoDTO));
    }

    @Test
    @DisplayName("Quando aluno não existe deve inserir com sucesso")
    void inserir_sucesso() {
        AlunoDTO alunoDTO = new AlunoDTO(1234,"nome do aluno");
        Response result = controller.inserir(alunoDTO);
        assertEquals(Response.Status.CREATED.getStatusCode(), result.getStatus());
        assertNotNull(result.getEntity());
        assertInstanceOf(AlunoDTO.class , result.getEntity());
    }
}