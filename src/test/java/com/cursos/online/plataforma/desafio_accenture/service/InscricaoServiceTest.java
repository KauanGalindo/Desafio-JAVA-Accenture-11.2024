package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.entity.Inscricao;
import com.cursos.online.plataforma.desafio_accenture.repository.InscricaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class InscricaoServiceTest {

    @Mock
    private InscricaoRepository inscricaoRepository;

    @Mock
    private AlunoService alunoService;

    @Mock
    private CursoService cursoService;

    @InjectMocks
    private InscricaoService inscricaoService;

    public InscricaoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInscreverAluno() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);

        Curso curso = new Curso();
        curso.setId(1L);

        when(alunoService.buscaAlunoPorId(1L)).thenReturn(Optional.of(aluno));
        when(cursoService.buscaCursoPorId(1L)).thenReturn(Optional.of(curso));

        Inscricao inscricao = new Inscricao();
        inscricao.setId(1L);
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        when(inscricaoRepository.save(any(Inscricao.class))).thenReturn(inscricao);

        Inscricao inscricaoSalva = inscricaoService.inscricaoAluno(1L, 1L);

        assertThat(inscricaoSalva).isNotNull();
        assertThat(inscricaoSalva.getAluno().getId()).isEqualTo(1L);
        assertThat(inscricaoSalva.getCurso().getId()).isEqualTo(1L);
    }
}
