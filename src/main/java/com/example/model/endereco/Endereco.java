package com.example.model.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Endereco {
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;


    public Endereco(EnderecoRequestDTO data) {
        this.rua = data.rua();
        this.bairro = data.bairro();
        this.numero = data.numero();
        this.complemento = data.complemento();
        this.cep = data.cep();
        this.cidade = data.cidade();
        this.estado = data.estado();

    }
}
