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
        return this.motoristaBusiness.listarUm(id);
    }

    @PutMapping("/{id}")
    public Motorista editar(@RequestBody @Valid @PathVariable Long id, Motorista motorista){
        return motoristaBusiness.alterarMotorista(id, motorista);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.motoristaBusiness.excluirMotorista(id);
    }



    /*
    * Será necessário implementar a busca por motorista, edição de motorista e exclusão de motorista.
    * Lembrando que:
    *
    * No padrão REST, as requisições são do seguinte padrão:
    *
    * POST      /motorista => Cria um Motorista
    * PUT       /motorista/1 => Altera o Motorista de ID 1
    * GET       /motorista => Retorna todos os Motoristas
    * GET       /motorista/1 => Retorna o Motorista de ID 1
    * DELETE    /motorista/1 => Delete o Motorista de ID 1
    *
    * Coisas que vão te ajudar:
    *   Anotação @PathVariable
    *
    *
    *
    *
    * Ao final, fazer os mesmos controllers para Marca e Carro
    *
    * */

}
