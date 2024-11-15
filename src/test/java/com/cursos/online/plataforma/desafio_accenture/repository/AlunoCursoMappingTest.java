package com.cursos.online.plataforma.desafio_accenture.repository;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.entity.Inscricao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Transactional
@Rollback
public class AlunoCursoMappingTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Test
    public void testSalvarAlunoCursoInscricao() {

        Aluno aluno = new Aluno();
        aluno.setNome("Aluno");
        aluno.setEmail("aluno@email.com");
        aluno.setDataCadastro(LocalDate.now());
        alunoRepository.save(aluno);

        Curso curso = new Curso();
        curso.setNome("Curso 1");
        curso.setDescricao("Curso SAP");
        curso.setDataCriacao(LocalDate.now());
        cursoRepository.save(curso);

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(LocalDate.now());
        inscricaoRepository.save(inscricao);

        Aluno alunoSalvo = alunoRepository.findById(aluno.getId()).orElse(null);
        Curso cursoSalvo = cursoRepository.findById(curso.getId()).orElse(null);
        Inscricao inscricaoSalva = inscricaoRepository.findById(inscricao.getId()).orElse(null);

        assertThat(alunoSalvo).isNotNull();
        assertThat(cursoSalvo).isNotNull();
        assertThat(inscricaoSalva).isNotNull();

        List<Inscricao> inscricoesDoAluno = inscricaoRepository.findAlunoById(alunoSalvo.getId());
        List<Inscricao> inscricoesDoCurso = inscricaoRepository.findAlunoById(cursoSalvo.getId());

        assertThat(inscricoesDoAluno).isNotEmpty();
        assertThat(inscricoesDoCurso).isNotEmpty();
        assertThat(inscricoesDoAluno.get(0).getCurso()).isEqualTo(cursoSalvo);
        assertThat(inscricoesDoCurso.get(0).getAluno()).isEqualTo(alunoSalvo);
    }
}
