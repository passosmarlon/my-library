package com.example.services;

import com.example.model.emprestimo.Emprestimo;
import com.example.model.emprestimo.EmprestimoRepository;
import com.example.model.emprestimo.EmprestimoRequestDTO;
import com.example.model.livro.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;
    private Livro livro;

    public Emprestimo registerEmprestimo(EmprestimoRequestDTO data) {
        Emprestimo emprestimoRequest = new Emprestimo(data);

        return repository.save(emprestimoRequest);

    }
}
