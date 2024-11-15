package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastraAluno(Aluno aluno) {
        aluno.setDataCadastro(LocalDate.now());
        return alunoRepository.save(aluno);
    }

    public Optional<Aluno> buscaAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public List<Aluno> listarTodosOsAlunos() {
        return alunoRepository.findAll();
    }
}
