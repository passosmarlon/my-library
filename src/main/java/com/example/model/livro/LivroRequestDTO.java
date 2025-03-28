package com.example.model.livro;

public record LivroRequestDTO(Long id,
                              String titulo,
                              String autor,
                              int anoPublicacao,
                              String genero,
                              int quantidadeDisponivel) {
}
