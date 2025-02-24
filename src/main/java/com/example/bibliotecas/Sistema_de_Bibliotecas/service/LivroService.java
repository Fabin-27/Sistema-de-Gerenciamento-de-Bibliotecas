package com.example.bibliotecas.Sistema_de_Bibliotecas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.LivroDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDoLivro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeLivro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.LivroRepository;

import jakarta.transaction.Transactional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) throws Exception {
        return livroRepository.findById(id).orElseThrow(() -> new Exception());

    }

    public List<Livro> findByCategoria(TipoDeLivro tipoLivro) throws Exception {
        List<Livro> livros = livroRepository.findLivroByCategoria(tipoLivro);

        if (livros.isEmpty()) {
            System.out.println("Nenhum Livro encotrado ");

        }
        return livros;
    }

    public Livro createLivro(LivroDto livro) {
        Livro newLivro = new Livro(livro);
        saveLivro(newLivro);
        return newLivro;
    };

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);

    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);

    }

    @Transactional
    public Livro alterLivro(Long id, String titulo, String autor, Integer anoDePublicacao, TipoDeLivro categoria,
            String editora, StatusDoLivro statusLivro) throws Exception {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new Exception("Livro não encontrado"));

        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoDePublicacao(anoDePublicacao);
        livro.setCategoria(categoria);
        livro.setEditora(editora);
        livro.setStatusLivro(statusLivro);

        return livroRepository.save(livro);
    }
}
