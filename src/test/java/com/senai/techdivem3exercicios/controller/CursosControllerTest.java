package com.senai.techdivem3exercicios.controller;

import com.senai.techdivem3exercicios.dto.AlunoDTO;
import com.senai.techdivem3exercicios.dto.CursoDTO;
import com.senai.techdivem3exercicios.exception.RegistroExistenteException;
import com.senai.techdivem3exercicios.mapper.AlunoMapper;
import com.senai.techdivem3exercicios.mapper.CursoMapper;
import com.senai.techdivem3exercicios.model.Aluno;
import com.senai.techdivem3exercicios.model.Curso;
import com.senai.techdivem3exercicios.service.AlunosService;
import com.senai.techdivem3exercicios.service.CursosService;
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
class CursosControllerTest {

    @Mock
    private CursosService service;

    @InjectMocks
    private CursosController controller;

    @Test
    @DisplayName("Quando curso existente deve lançar exeção")
    void inserir_falhaexistente() {
        CursoDTO cursoDTO = new CursoDTO("1234","Assunto curso",60);
        Curso curso = CursoMapper.INSTANCE.toModel(cursoDTO);
        Mockito.doThrow(new RegistroExistenteException("Curso", cursoDTO.getCodigo().toString())).when(service).inserir(Mockito.any(Curso.class));
        assertThrows(RegistroExistenteException.class, () -> controller.inserir(cursoDTO));
    }

    @Test
    @DisplayName("Quando curso não existe deve inserir com sucesso")
    void inserir_sucesso() {
        CursoDTO cursoDTO = new CursoDTO("1234","Assunto curso",60);
        Response result = controller.inserir(cursoDTO);
        assertEquals(Response.Status.CREATED.getStatusCode(), result.getStatus());
        assertNotNull(result.getEntity());
        assertInstanceOf(CursoDTO.class , result.getEntity());
    }
}