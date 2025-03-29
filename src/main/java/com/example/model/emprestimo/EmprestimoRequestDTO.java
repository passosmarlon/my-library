package com.example.model.emprestimo;

import com.example.model.cliente.Cliente;
import com.example.model.livro.Livro;

import java.time.LocalDateTime;

public record EmprestimoRequestDTO(Long id,
                                   LocalDateTime dataRetirada,
                                   LocalDateTime dataDevolucao,
                                   Status status,
                                   Cliente cliente,
                                   Livro livro) {
}
