package com.example.demo.business;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroBusiness {

    @Autowired
    private CarroRepository _carroRepository;

    public Carro criarCarro(Carro carro) {
        carro = _carroRepository.save(carro);
        return carro;
    }

    public List<Carro> listarTodos() {
        return _carroRepository.findAll();
    }

    public Carro listarUm(Long id){
        return _carroRepository.getOne(id);
    }


    public Carro alterarCarro(Long id, Carro carro){
        _carroRepository.deleteById(id);
        carro = _carroRepository.save(carro);
        return carro;
    }

    public void excluirCarro(Long id){
        _carroRepository.deleteById(id);
    }

    public Optional<Carro> buscarCarro(Long id){
        Optional<Carro> carro;
        carro = _carroRepository.findById(id);
        return carro;
    }
    /*
    * Será necessário implementar a lógica para alterar, excluir e buscar motorista.
    *
    * Ao final, implemente também o mesmo para Marca e Carro
    *
    * */
}
