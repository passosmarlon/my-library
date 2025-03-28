package com.example.model;
import com.example.model.cliente.Cliente;
import com.example.model.livro.Livro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "emprestimo")
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
