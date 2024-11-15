package com.cursos.online.plataforma.desafio_accenture.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataCadastro;
}
