package com.example.demo.business;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Carro alterarCarro(Long id, Carro carro){
        carro.setId(id);
        carro = _carroRepository.save(carro);
        return carro;
    }

    public void excluirCarro(Long id){
        _carroRepository.deleteById(id);
    }

    public Carro buscarCarro(Long id){
        Carro carro;
        carro = _carroRepository.findById(id).get();
        return carro;
    }
}
