package com.example.bibliotecas.Sistema_de_Bibliotecas.dto;

import java.util.Date;

public record EmprestimoDto(String cpfCliente, String tituloLivro, Date dataDevolucao) {

}
