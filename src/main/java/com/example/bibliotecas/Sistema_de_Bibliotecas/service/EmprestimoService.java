package com.example.bibliotecas.Sistema_de_Bibliotecas.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.EmprestimoDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Emprestimo;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Livro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDoEmprestimo;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.StatusDoLivro;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.ClienteRepository;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.EmprestimoRepository;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.LivroRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LivroRepository livroRepository;

    public List<Emprestimo> findAll() {
        return emprestimoRepository.findAll();

    }

    public Emprestimo findById(Long id) throws Exception {
        return emprestimoRepository.findById(id).orElseThrow(() -> new Exception());
    }

    public List<Emprestimo> findByClienteId(Long id) {
        return emprestimoRepository.findByClienteId(id);

    }

    public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }

    public Emprestimo createEmprestimo(EmprestimoDto emprestimoDto) throws Exception {

        Cliente cliente = clienteRepository.findClienteByCpf(emprestimoDto.cpfCliente())
                .orElseThrow(() -> new Exception("Cliente não encontrado"));

        List<Livro> livros = livroRepository.findByTituloContainingIgnoreCase(emprestimoDto.tituloLivro());

        if (livros.isEmpty()) {
            throw new Exception("Nenhum livro encontrado com o título: " + emprestimoDto.tituloLivro());
        }

        Livro livroSelecionado = livros.get(0);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setLivro(livroSelecionado);
        Date DataEmprestimo = new Date();
        emprestimo.setDataEmprestimo(DataEmprestimo);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DataEmprestimo);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date dataDevolucao = calendar.getTime();
        emprestimo.setDataDevolucao(dataDevolucao);
        livroSelecionado.setStatusLivro(StatusDoLivro.Emprestado);
        livroRepository.save(livroSelecionado);

        emprestimo.setStatusEmprestimo(StatusDoEmprestimo.Emprestado);

        return emprestimoRepository.save(emprestimo);
    }

}
