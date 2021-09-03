package com.example.demo.business;

import com.example.demo.model.Motorista;
import com.example.demo.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Motorista listarUm(Long id){
        return _motoristaRepository.getOne(id);
    }

    public Motorista alterarMotorista(Long id, Motorista motorista){
        _motoristaRepository.deleteById(id);
        motorista = _motoristaRepository.save(motorista);
        return motorista;
    }

    public void excluirMotorista(Long id){
        _motoristaRepository.deleteById(id);
    }

    public Optional<Motorista> buscarMotorista(Long id){
        Optional<Motorista> motorista;
        motorista = _motoristaRepository.findById(id);
        return motorista;
    }
    /*
    * Será necessário implementar a lógica para alterar, excluir e buscar motorista.
    *
    * Ao final, implemente também o mesmo para Marca e Carro
    *
    * */
}
