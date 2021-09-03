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
    public Marca buscarMarca(@PathVariable Long id) {
        return this.marcaBusiness.buscarMarca(id);
    }

    @PutMapping("/{id}")
    public Marca editar(@PathVariable Long id, @RequestBody @Valid Marca marca){
        return marcaBusiness.alterarMarca(id, marca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.marcaBusiness.excluirMarca(id);
    }



}
