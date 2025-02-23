package com.example.bibliotecas.Sistema_de_Bibliotecas.dto;

import java.util.Date;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDoEmprestimo;

public record EmprestimoDto(Cliente cliente, Livro livro, Date dataEmprestimo, Date dataDevolucao,
        StatusDoEmprestimo statusEmprestimo) {

}
