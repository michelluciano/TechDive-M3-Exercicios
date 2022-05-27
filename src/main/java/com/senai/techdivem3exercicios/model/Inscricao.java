package com.senai.techdivem3exercicios.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Inscricao {

    @Id
    @GeneratedValue()
    private Integer id;

    private Aluno aluno;

    private Curso curso;

    
}
