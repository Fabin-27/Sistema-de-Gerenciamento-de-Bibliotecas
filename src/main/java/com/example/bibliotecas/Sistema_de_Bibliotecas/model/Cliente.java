package com.example.bibliotecas.Sistema_de_Bibliotecas.model;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.ClienteDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "cliente")
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Enumerated(EnumType.STRING)
    private StatusDaConta statusConta;

    @Enumerated(EnumType.STRING)
    private TipoDeCliente tipoCliente;

    public Cliente(ClienteDto cliente) {
        nome = cliente.nome();
        email = cliente.email();
        cpf = cliente.cpf();
        telefone = cliente.telefone();
        endereco = cliente.endereco();
        statusConta = cliente.statusConta();
        tipoCliente = cliente.tipoCliente();

    }

}