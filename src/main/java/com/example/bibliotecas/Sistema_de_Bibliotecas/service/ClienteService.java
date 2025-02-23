package com.example.bibliotecas.Sistema_de_Bibliotecas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecas.Sistema_de_Bibliotecas.dto.ClienteDto;
import com.example.bibliotecas.Sistema_de_Bibliotecas.model.Cliente;
import com.example.bibliotecas.Sistema_de_Bibliotecas.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();

    }

    public Cliente findById(Long id) throws Exception {
        return clienteRepository.findById(id).orElseThrow(() -> new Exception());

    }

    public Cliente findByCpf(String cpf) throws Exception {
        return clienteRepository.findClienteByCpf(cpf).orElseThrow(() -> new Exception());
    }

    public Cliente createCliente(ClienteDto cliente) {
        Cliente newCliente = new Cliente(cliente);
        saveCliente(newCliente);
        return newCliente;

    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);

    }

}
