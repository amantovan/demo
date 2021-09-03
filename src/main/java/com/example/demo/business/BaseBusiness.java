package com.example.demo.business;


import com.example.demo.model.EntidadeBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class BaseBusiness<E extends EntidadeBase> {

    private final JpaRepository<E, Long> repository;

    BaseBusiness(JpaRepository<E, Long> repository) {
        this.repository = repository;
    }

    public E criar(E e) {
        e = repository.save(e);
        return e;
    }

    public List<E> listarTodos() {
        return repository.findAll();
    }

    public E alterar(Long id, E e){
        e.setId(id);
        e = repository.save(e);
        return e;
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public E buscar(Long id){
        E e;
        e = repository.findById(id).get();
        return e;
    }
}
