package com.example.controllers;

import com.example.model.cliente.ClienteRequestDTO;
import com.example.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity getAllCliente() {
        var clienteAll = clienteService.getAllCliente();
        return ResponseEntity.ok(clienteAll);
    }

    @PostMapping
    public ResponseEntity saveCliente(@RequestBody ClienteRequestDTO data) {
        clienteService.saveCliente(data);
        return ResponseEntity.ok(data);
    }


    @PutMapping
    public ResponseEntity updateCliente(@RequestBody ClienteRequestDTO data) {
        var cliente = clienteService.updateCliente(data);
        if (cliente != null) {
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable Long id) {
        var cliente = clienteService.deleteCliente(id);
        if (cliente != null) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
