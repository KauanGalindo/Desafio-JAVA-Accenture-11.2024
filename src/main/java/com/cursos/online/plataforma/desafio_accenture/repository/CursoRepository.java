package com.cursos.online.plataforma.desafio_accenture.repository;

import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
