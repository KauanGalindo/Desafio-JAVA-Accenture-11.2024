package com.cursos.online.plataforma.desafio_accenture.service;

import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.entity.Inscricao;
import com.cursos.online.plataforma.desafio_accenture.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    public Inscricao inscricaoAluno(Long alunoId, Long cursoId) {
        Aluno aluno = alunoService.buscaAlunoPorId(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não foi encontrado"));
        Curso curso = cursoService.buscaCursoPorId(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso não foi encontrado"));

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(LocalDate.now());
        return inscricaoRepository.save(inscricao);
    }

    public List<Inscricao> ListarInscricaoPorAluno(Long alunoId) {
        return inscricaoRepository.findAlunoById(alunoId);
    }

    public List<Inscricao> ListarIncricaoPorCurso(Long cursoId) {
        return inscricaoRepository.findCursoById(cursoId);
    }

}
