package com.senai.techdivem3exercicios.service;

import com.senai.techdivem3exercicios.dao.AlunosDAO;
import com.senai.techdivem3exercicios.exception.RegistroExistenteException;
import com.senai.techdivem3exercicios.exception.RegistroNaoExistenteException;
import com.senai.techdivem3exercicios.model.Aluno;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlunosService {

    @Inject
    private AlunosDAO alunosDAO;

    public void inserir(Aluno aluno) {
        boolean existente = alunosDAO.find(aluno.getMatricula()).isPresent();
        if (existente)
            throw new RegistroExistenteException("Aluno", aluno.getMatricula().toString());
        alunosDAO.save(aluno);
    }

    public void alterar(Aluno aluno) {
        boolean existente = alunosDAO.find(aluno.getMatricula()).isPresent();
        if (!existente)
            throw new RegistroNaoExistenteException("Aluno", aluno.getMatricula().toString());
        alunosDAO.update(aluno);
    }

    public void excluir(Integer matricula) {
        boolean existente = alunosDAO.find(matricula).isPresent();
        if (!existente)
            throw new RegistroNaoExistenteException("Aluno", matricula.toString());
        alunosDAO.delete(matricula);
    }

    public List<Aluno> obter(String nomePesquisa) {
        List<Aluno> alunos = alunosDAO.findAll();
        if (nomePesquisa != null)
            alunos = alunos.stream().filter(a -> a.getNome().contains(nomePesquisa)).collect(Collectors.toList());
        return alunos;
    }

    public Aluno obter(Integer matricula) {
        Optional<Aluno> alunoOpt = alunosDAO.find(matricula);
        return alunoOpt.orElseThrow(() -> new RegistroNaoExistenteException("Aluno", matricula.toString()));
    }

}
