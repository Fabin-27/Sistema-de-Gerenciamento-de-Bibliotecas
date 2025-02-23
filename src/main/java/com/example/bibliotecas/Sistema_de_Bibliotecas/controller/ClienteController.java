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

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.ClienteDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController { // cria um novo projeto e vai adicionando as coisas aos poucos

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAllClientes() {
        List<Cliente> allClientes = clienteService.findAll();
        return new ResponseEntity<>(allClientes, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) throws Exception {
        Cliente cliente = clienteService.findById(id);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> findClienteByCpf(@PathVariable String cpf) throws Exception {
        Cliente cliente = clienteService.findByCpf(cpf);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        else {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDto cliente) {
        Cliente newCliente = clienteService.createCliente(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.ok("Cliente deletado com sucesso!");
    }

}
