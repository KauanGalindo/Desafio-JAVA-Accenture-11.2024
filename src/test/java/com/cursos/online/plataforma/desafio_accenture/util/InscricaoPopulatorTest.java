package com.cursos.online.plataforma.desafio_accenture.util;

import com.cursos.online.plataforma.desafio_accenture.dto.AlunoDTO;
import com.cursos.online.plataforma.desafio_accenture.dto.CursoDTO;
import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class InscricaoPopulatorTest {

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    private Aluno aluno;
    private Curso curso;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno");
        aluno.setEmail("aluno@email.com");
        aluno.setDataCadastro(LocalDate.now());

        curso = new Curso();
        curso.setId(1L);
        curso.setNome("Curso 1");
        curso.setDescricao("Curso SAP");
        curso.setDataCriacao(LocalDate.now());
    }

    @Test
    public void testToAlunoDTO() {
        AlunoDTO alunoDTO = inscricaoPopulator.toAlunoDTO(aluno);

        assertThat(alunoDTO.getId()).isEqualTo(aluno.getId());
        assertThat(alunoDTO.getNome()).isEqualTo(aluno.getNome());
        assertThat(alunoDTO.getEmail()).isEqualTo(aluno.getEmail());
        assertThat(alunoDTO.getDataCadastro()).isEqualTo(aluno.getDataCadastro());
    }

    @Test
    public void testToCursoDTO() {
        CursoDTO cursoDTO = inscricaoPopulator.toCursoDTO(curso);

        assertThat(cursoDTO.getId()).isEqualTo(curso.getId());
        assertThat(cursoDTO.getNome()).isEqualTo(curso.getNome());
        assertThat(cursoDTO.getDescricao()).isEqualTo(curso.getDescricao());
        assertThat(cursoDTO.getDataCriacao()).isEqualTo(curso.getDataCriacao());
    }
}
