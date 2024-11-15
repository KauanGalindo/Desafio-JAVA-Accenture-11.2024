package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    public CursoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarCurso() {
        Curso curso = new Curso();
        curso.setNome("Curso SAP");

        when(cursoRepository.save(curso)).thenReturn(curso);

        Curso cursoSalvo = cursoService.cadastraCurso(curso);
        assertThat(cursoSalvo.getNome()).isEqualTo("Curso SAP");
    }

    @Test
    public void testBuscarCursoPorId() {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setNome("Curso SAP");

        when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));

        Optional<Curso> resultado = cursoService.buscaCursoPorId(1L);
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Curso SAP");
    }
}
