package com.example.model.cliente;

import com.example.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private boolean active;

    public Cliente(ClienteRequestDTO data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
        this.endereco = data.endereco();
        this.active = true;
    }
}
