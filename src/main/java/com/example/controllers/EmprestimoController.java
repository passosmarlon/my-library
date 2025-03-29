package com.example.controllers;

import com.example.model.emprestimo.EmprestimoRequestDTO;
import com.example.services.ClienteService;
import com.example.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity registerEmprestimo(@RequestBody EmprestimoRequestDTO data) {
        emprestimoService.registerEmprestimo(data);
        return ResponseEntity.ok().build();
    }
}
