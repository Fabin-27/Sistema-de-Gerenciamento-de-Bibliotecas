package com.example.bibliotecas.Sistema_de_Bibliotecas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findLivroByIsbn(String isbn);

}