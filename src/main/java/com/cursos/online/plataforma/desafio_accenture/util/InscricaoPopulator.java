package com.cursos.online.plataforma.desafio_accenture.util;

import com.cursos.online.plataforma.desafio_accenture.dto.AlunoDTO;
import com.cursos.online.plataforma.desafio_accenture.dto.CursoDTO;
import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {

    public AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public CursoDTO toCursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }
}
