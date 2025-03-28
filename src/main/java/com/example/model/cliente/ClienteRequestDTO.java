package com.example.model.cliente;

import com.example.model.endereco.Endereco;

public record ClienteRequestDTO(Long id,
                                String nome,
                                String email,
                                String telefone,
                                Endereco endereco) {
}
