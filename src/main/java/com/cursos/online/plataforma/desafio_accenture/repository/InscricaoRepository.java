package com.cursos.online.plataforma.desafio_accenture.repository;

import com.cursos.online.plataforma.desafio_accenture.entity.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findAlunoById(Long alunoId);
    List<Inscricao> findCursoById(Long cursoId);
}
