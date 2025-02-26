package com.example.bibliotecas.Sistema_de_Bibliotecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.EmprestimoDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Emprestimo;
import com.example.bibliotecas.Sistema_de_Bibliotecas.service.EmprestimoService;

@Controller
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll() {
        List<Emprestimo> emprestimos = emprestimoService.findAll();
        return new ResponseEntity<>(emprestimos, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Long id) throws Exception {
        Emprestimo emprestimo = emprestimoService.findById(id);

        if (emprestimo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(emprestimo, HttpStatus.OK);

    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<List<Emprestimo>> findByClienteId(@PathVariable Long id) {
        List<Emprestimo> emprestimosDoCliente = emprestimoService.findByClienteId(id);

        if (emprestimosDoCliente.isEmpty()) {
            return ResponseEntity.noContent().build();

        }
        return new ResponseEntity<>(emprestimosDoCliente, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Emprestimo> createEmprestimo(@RequestBody EmprestimoDto emprestimoDto) throws Exception {

        Emprestimo emprestimo = emprestimoService.createEmprestimo(emprestimoDto);
        return new ResponseEntity<>(emprestimo, HttpStatus.CREATED);

    }

}
