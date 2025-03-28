package com.example.controllers;

import com.example.model.cliente.ClienteRequestDTO;
import com.example.model.livro.LivroRequestDTO;
import com.example.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity getAllLivro() {
        var getAll = livroService.getAllLivro();
        return ResponseEntity.ok(getAll);
    }

    @PostMapping
    public ResponseEntity saveLivro(@RequestBody LivroRequestDTO data) {
        livroService.saveLivro(data);
        return ResponseEntity.ok(data);
    }

    @PutMapping
    public ResponseEntity updateLivro(@RequestBody LivroRequestDTO data) {
        var livro = livroService.updateLivro(data);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLivro(@PathVariable Long id) {
        var cliente = livroService.deleteLivro(id);
        if (cliente != null) {

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
