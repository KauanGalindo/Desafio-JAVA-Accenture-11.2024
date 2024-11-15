package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.repository.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    public AlunoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Aluno");
        aluno.setEmail("aluno@email.com");

        when(alunoRepository.save(aluno)).thenReturn(aluno);
    }

    @Test
    public void testBuscarAlunoPorId() {
        Aluno aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Aluno");

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        Optional<Aluno> resultado = alunoService.buscaAlunoPorId(1L);
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Aluno");
    }
}
