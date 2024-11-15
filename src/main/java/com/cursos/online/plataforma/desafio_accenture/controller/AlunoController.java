package com.cursos.online.plataforma.desafio_accenture.controller;

import com.cursos.online.plataforma.desafio_accenture.dto.AlunoDTO;
import com.cursos.online.plataforma.desafio_accenture.entity.Aluno;
import com.cursos.online.plataforma.desafio_accenture.service.AlunoService;
import com.cursos.online.plataforma.desafio_accenture.util.InscricaoPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private InscricaoPopulator inscricaoPopulator;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno = alunoService.cadastraAluno(aluno);
        return inscricaoPopulator.toAlunoDTO(aluno);
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.buscaAlunoPorId(id).
                orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
        return inscricaoPopulator.toAlunoDTO(aluno);
    }

    @GetMapping
    public List<AlunoDTO> listarAlunos() {
        return alunoService.listarTodosOsAlunos()
                .stream()
                .map(inscricaoPopulator::toAlunoDTO)
                .collect(Collectors.toList());
    }
}
