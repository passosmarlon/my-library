package com.example.model.endereco;

import com.example.model.cliente.Cliente;

public record EnderecoRequestDTO(Long id,
                                 String rua,
                                 String bairro,
                                 String numero,
                                 String complemento,
                                 String cep,
                                 String cidade,
                                 String estado,
                                 Cliente cliente) {
}
