package com.example.demo.controller;

import com.example.demo.business.CarroBusiness;
import com.example.demo.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    CarroBusiness carroBusiness;

    @PostMapping
    public Carro criar(@RequestBody @Valid Carro carro) {
        carro = carroBusiness.criarCarro(carro);
        return carro;
    }

    @GetMapping
    public List<Carro> buscarTodos() {
        return carroBusiness.listarTodos();
    }

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Long id) {   //testar
        return this.carroBusiness.listarUm(id);
    }

    @PutMapping("/{id}")
    public Carro editar(@RequestBody @Valid @PathVariable Long id, Carro carro){
        return carroBusiness.alterarCarro(id, carro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.carroBusiness.excluirCarro(id);
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
