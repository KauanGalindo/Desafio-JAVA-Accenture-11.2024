package com.cursos.online.plataforma.desafio_accenture.repository;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
