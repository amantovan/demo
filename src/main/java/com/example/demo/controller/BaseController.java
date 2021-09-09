package com.example.demo.controller;

import com.example.demo.business.BaseBusiness;
import com.example.demo.filters.BaseFilter;
import com.example.demo.model.EntidadeBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public abstract class BaseController<E extends EntidadeBase> {

    protected final BaseBusiness<E> _business;

    BaseFilter baseFilter;

    public BaseController(BaseBusiness<E> business) {
        _business = business;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody E e) {
        return _business.criar(e);
    }

    @GetMapping
    public List<E> buscarTodos() {
        return _business.listarTodos(baseFilter);
    }

    @GetMapping("/{id}")
    public E buscar(@PathVariable Long id) {
        return this._business.buscar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody @Valid E e){
        return _business.alterar(id, e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this._business.excluir(id);
    }


}
