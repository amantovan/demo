package com.example.demo.controller;

import com.example.demo.business.MotoristaBusiness;
import com.example.demo.model.Motorista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    MotoristaBusiness motoristaBusiness;

    @PostMapping
    public Motorista criar(@RequestBody @Valid Motorista motorista) {
        motorista = motoristaBusiness.criarMotorista(motorista);
        return motorista;
    }

    @GetMapping
    public List<Motorista> buscarTodos() {
        return motoristaBusiness.listarTodos();
    }

    @GetMapping("/{id}")
    public Motorista buscarMotorista(@PathVariable Long id) {   //testar
        return this.motoristaBusiness.buscarMotorista(id);
    }

    @PutMapping("/{id}")
    public Motorista editar(@PathVariable Long id, @RequestBody @Valid Motorista motorista){
        return motoristaBusiness.alterarMotorista(id, motorista);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.motoristaBusiness.excluirMotorista(id);
    }
}
