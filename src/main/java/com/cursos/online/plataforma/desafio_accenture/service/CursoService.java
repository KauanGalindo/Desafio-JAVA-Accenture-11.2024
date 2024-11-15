package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso cadastraCurso(Curso curso) {
        curso.setDataCriacao(LocalDate.now());
        return cursoRepository.save(curso);
    }

    public Optional<Curso> buscaCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public List<Curso> listarTodosOsCursos() {
        return cursoRepository.findAll();
    }
}
