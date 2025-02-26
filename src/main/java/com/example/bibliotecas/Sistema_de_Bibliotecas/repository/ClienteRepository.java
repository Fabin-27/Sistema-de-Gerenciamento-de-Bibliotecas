package com.example.bibliotecas.Sistema_de_Bibliotecas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeCliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findClienteByCpf(String cpf);

    List<Cliente> findClienteByTipoCliente(TipoDeCliente tipoCliente);

}
