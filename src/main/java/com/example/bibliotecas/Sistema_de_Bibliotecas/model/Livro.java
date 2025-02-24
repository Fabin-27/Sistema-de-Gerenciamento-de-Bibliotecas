package com.example.bibliotecas.Sistema_de_Bibliotecas.model;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.LivroDto;

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

@Entity(name = "livro")
@Table(name = "livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private String editora;

    private Integer anoDePublicacao;

    @Column(unique = true)
    private String isbn;

    @Enumerated(EnumType.STRING)
    private TipoDeLivro categoria;

    @Enumerated(EnumType.STRING)
    private StatusDoLivro statusLivro;

    public Livro(LivroDto livro) {
        titulo = livro.titulo();
        autor = livro.autor();
        editora = livro.editora();
        anoDePublicacao = livro.anoDePublicacao();
        isbn = livro.isbn();
        categoria = livro.categoria();
        statusLivro = livro.statusLivro();

    }

}
