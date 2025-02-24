package com.example.bibliotecas.Sistema_de_Bibliotecas.dto;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDoLivro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeLivro;

public record LivroDto(Long id, String titulo, String autor, String editora, Integer anoDePublicacao,
                String isbn, TipoDeLivro categoria, StatusDoLivro statusLivro) {

}
