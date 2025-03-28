package com.example.model.livro;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "livro")
@Entity
@NoArgsConstructor
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private int quantidadeDisponivel;
    private boolean active;

    public Livro(LivroRequestDTO data) {
        this.titulo = data.titulo();
        this.autor = data.autor();
        this.anoPublicacao = data.anoPublicacao();
        this.genero = data.genero();
        this.quantidadeDisponivel = data.quantidadeDisponivel();
        this.active = true;
    }
}
