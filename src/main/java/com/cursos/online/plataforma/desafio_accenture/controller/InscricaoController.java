package com.cursos.online.plataforma.desafio_accenture.controller;

import com.cursos.online.plataforma.desafio_accenture.dto.AlunoDTO;
import com.cursos.online.plataforma.desafio_accenture.dto.CursoDTO;
import com.cursos.online.plataforma.desafio_accenture.service.InscricaoService;
import com.cursos.online.plataforma.desafio_accenture.util.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    public String inscreverAluno(@RequestParam Long alunoId, @RequestParam Long cursoId) {
        inscricaoService.inscricaoAluno(alunoId, cursoId);
        return "Aluno inscrito com sucesso";
    }

    @GetMapping("/cursosPorAluno/{alunoId}")
    public List<CursoDTO> listarCursosPorAluno(@PathVariable Long alunoId) {
        return inscricaoService.ListarInscricaoPorAluno(alunoId)
                .stream()
                .map(inscricao -> inscricaoPopulator.toCursoDTO(inscricao.getCurso()))
                .collect(Collectors.toList());
    }

    @GetMapping("/alunosPorCurso/{cursoId}")
    public List<AlunoDTO> listarAlunosPorCurso(@PathVariable Long cursoId) {
        return inscricaoService.ListarIncricaoPorCurso(cursoId)
                .stream()
                .map(inscricao -> inscricaoPopulator.toAlunoDTO(inscricao.getAluno()))
                .collect(Collectors.toList());
    }
}
