package com.example.bibliotecas.Sistema_de_Bibliotecas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeLivro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findLivroByCategoria(TipoDeLivro tipoLivro);

}