package com.example.bibliotecas.Sistema_de_Bibliotecas.dto;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDaConta;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeCliente;

public record ClienteDto(String nome, String email, String cpf,
        String telefone, String endereco,
        StatusDaConta statusConta, TipoDeCliente tipoCliente) {

}
