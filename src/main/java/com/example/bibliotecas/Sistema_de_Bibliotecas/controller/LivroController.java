package com.example.bibliotecas.Sistema_de_Bibliotecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.LivroDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeLivro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {

        List<Livro> allLivros = livroService.findAll();

        return new ResponseEntity<>(allLivros, HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) throws Exception {
        Livro livro = livroService.findById(id);

        if (livro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        else {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        }

    }

    @GetMapping("/categoria/{tipoLivro}")
    public ResponseEntity<List<Livro>> findLivroByCategoria(@PathVariable TipoDeLivro tipoLivro) throws Exception {
        List<Livro> livro = livroService.findByCategoria(tipoLivro);

        if (livro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        else {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody LivroDto livro) {
        Livro newLivro = livroService.createLivro(livro);
        return new ResponseEntity<>(newLivro, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.ok("Livro deletado com sucesso!");

    }

}
