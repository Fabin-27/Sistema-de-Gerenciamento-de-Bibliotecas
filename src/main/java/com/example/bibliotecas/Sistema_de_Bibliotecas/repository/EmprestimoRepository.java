package com.example.bibliotecas.Sistema_de_Bibliotecas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    List<Emprestimo> findByClienteId(Long id);

    List<Emprestimo> findByLivroId(Long id);

}
