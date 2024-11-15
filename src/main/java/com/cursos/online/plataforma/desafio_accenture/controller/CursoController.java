package com.cursos.online.plataforma.desafio_accenture.controller;

import com.cursos.online.plataforma.desafio_accenture.dto.CursoDTO;
import com.cursos.online.plataforma.desafio_accenture.entity.Curso;
import com.cursos.online.plataforma.desafio_accenture.service.CursoService;
import com.cursos.online.plataforma.desafio_accenture.util.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso = cursoService.cadastraCurso(curso);
        return inscricaoPopulator.toCursoDTO(curso);
    }

    @GetMapping("/{id}")
    public CursoDTO buscarCurso(@PathVariable Long id) {
        Curso curso = cursoService.buscaCursoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
        return inscricaoPopulator.toCursoDTO(curso);
    }

    @GetMapping
    public List<CursoDTO> listarCursos() {
        return cursoService.listarTodosOsCursos()
                .stream()
                .map(inscricaoPopulator::toCursoDTO)
                .collect(Collectors.toList());
    }
}
