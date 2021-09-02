package com.example.demo.business;

import com.example.demo.model.Motorista;
import com.example.demo.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaBusiness {

    @Autowired
    private MotoristaRepository _motoristaRepository;

    public Motorista criarMotorista(Motorista motorista) {
        motorista = _motoristaRepository.save(motorista);
        return motorista;
    }

    public List<Motorista> listarTodos() {
        return _motoristaRepository.findAll();
    }

    /*
    * Será necessário implementar a lógica para alterar, excluir e buscar motorista.
    *
    * Ao final, implemente também o mesmo para Marca e Carro
    *
    * */
}
