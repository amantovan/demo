package com.example.demo.controller;

import com.example.demo.business.BaseBusiness;
import com.example.demo.model.EntidadeBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public abstract class BaseController<E extends EntidadeBase> {

    private final BaseBusiness<E> _business;

    public BaseController(BaseBusiness<E> business) {
        _business = business;
    }

    @PostMapping
    public E criar(@RequestBody @Valid E e) {
        e = _business.criar(e);
        return e;
    }

    @GetMapping
    public List<E> buscarTodos() {
        return _business.listarTodos();
    }

    @GetMapping("/{id}")
    public E buscar(@PathVariable Long id) {
        return this._business.buscar(id);
    }

    @PutMapping("/{id}")
    public E editar( @PathVariable Long id, @RequestBody @Valid E e){
        return _business.alterar(id, e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this._business.excluir(id);
    }


}
