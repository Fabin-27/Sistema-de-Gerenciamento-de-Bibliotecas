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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.ClienteDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.TipoDeCliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

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

    @GetMapping("/tipo/{tipoCliente}")
    public ResponseEntity<List<Cliente>> findClienteByTipo(@PathVariable TipoDeCliente tipoCliente) throws Exception {
        List<Cliente> cliente = clienteService.findClienteByTipo(tipoCliente);

        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
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

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {

        try {
            Cliente clienteAlterado = clienteService.alterCliente(id,
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getCpf(),
                    cliente.getTelefone(),
                    cliente.getEndereco(),
                    cliente.getStatusConta(), cliente.getTipoCliente());
            return ResponseEntity.ok(clienteAlterado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

}
