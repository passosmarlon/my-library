package com.example.services;

import com.example.model.livro.Livro;
import com.example.model.livro.LivroRepository;
import com.example.model.livro.LivroRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public Iterable<Livro> getAllLivro() {
        return repository.findAllByActiveTrue();
    }

    public Livro saveLivro(LivroRequestDTO data) {
        Livro livroRequest = new Livro(data);
        return repository.save(livroRequest);
    }

    @Transactional
    public Livro updateLivro(LivroRequestDTO data) {
        Optional<Livro> livroOptional = repository.findById(data.id());
        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setTitulo(data.titulo());
            livro.setAutor(data.autor());
            livro.setAnoPublicacao(data.anoPublicacao());
            livro.setGenero(data.genero());
            livro.setQuantidadeDisponivel(data.quantidadeDisponivel());
            return livro;
        }
        return null;
    }

    @Transactional
    public Livro deleteLivro(Long id) {
        Optional<Livro> optionalLivro = repository.findById(id);
        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            livro.setActive(false);
            return livro;
        }
        return null;
    }
}
