package com.example.services;

import com.example.model.cliente.Cliente;
import com.example.model.cliente.ClienteRepository;
import com.example.model.cliente.ClienteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public Iterable<Cliente> getAllCliente() {
        return repository.findAllByActiveTrue();
    }

    public Cliente saveCliente (ClienteRequestDTO data) {
        Cliente clienteRequest = new Cliente(data);

        return repository.save(clienteRequest);

    }

    @Transactional
    public Cliente updateCliente(ClienteRequestDTO data) {
        Optional<Cliente> optionalCliente = repository.findById(data.id());
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNome(data.nome());
            cliente.setEmail(data.email());
            cliente.setTelefone(data.telefone());
            cliente.setEndereco(data.endereco());
            return cliente;
        }
        return null;
    }

    @Transactional
    public Cliente deleteCliente(Long id) {
        Optional<Cliente> optionalCliente = repository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setActive(false);
            return cliente;
        }
        return null;
    }
}
