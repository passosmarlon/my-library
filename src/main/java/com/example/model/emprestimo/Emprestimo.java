package com.example.model.emprestimo;
import com.example.model.cliente.Cliente;
import com.example.model.livro.Livro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "emprestimo")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    public Emprestimo(EmprestimoRequestDTO data) {
        this.id = data.id();
        this.dataRetirada = LocalDateTime.now();
        this.dataDevolucao = data.dataDevolucao();
        this.status = data.status();
        this.cliente = data.cliente();
        this.livro = data.livro();
    }

}
