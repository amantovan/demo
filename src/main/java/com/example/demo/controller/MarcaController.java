package com.example.demo.controller;

import com.example.demo.business.MarcaBusiness;
import com.example.demo.model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaBusiness marcaBusiness;

    @PostMapping
    public Marca criar(@RequestBody @Valid Marca marca) {
        marca = marcaBusiness.criarMarca(marca);
        return marca;
    }

    @GetMapping
    public List<Marca> buscarTodos() {
        return marcaBusiness.listarTodos();
    }

    @GetMapping("/{id}")
    public Marca buscarMarca(@PathVariable Long id) {   //testar
        return this.marcaBusiness.listarUm(id);
    }

    @PutMapping("/{id}")
    public Marca editar(@RequestBody @Valid @PathVariable Long id, Marca marca){
        return marcaBusiness.alterarMarca(id, marca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.marcaBusiness.excluirMarca(id);
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
