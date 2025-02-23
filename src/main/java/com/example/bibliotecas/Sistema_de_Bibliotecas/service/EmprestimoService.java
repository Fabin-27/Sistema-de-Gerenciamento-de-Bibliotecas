package com.example.bibliotecas.Sistema_de_Bibliotecas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Emprestimo;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();

    }

    public Emprestimo findById(Long id) throws Exception {
        return emprestimoRepository.findById(id).orElseThrow(() -> new Exception());
    }

    public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }

}
