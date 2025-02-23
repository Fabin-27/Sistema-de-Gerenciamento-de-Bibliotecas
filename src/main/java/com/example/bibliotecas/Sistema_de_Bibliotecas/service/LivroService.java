package com.example.bibliotecas.Sistema_de_Bibliotecas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.LivroDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.LivroRepository;

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

    public Livro createLivro(LivroDto livro) {
        Livro newLivro = new Livro();
        saveLivro(newLivro);
        return newLivro;
    };

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);

    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);

    }

}
