package com.example.demo.business;

import com.example.demo.model.Marca;
import com.example.demo.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaBusiness {

    @Autowired
    private MarcaRepository _marcaRepository;

    public Marca criarMarca(Marca marca) {
        marca = _marcaRepository.save(marca);
        return marca;
    }

    public List<Marca> listarTodos() {
        return _marcaRepository.findAll();
    }

    public Marca listarUm(Long id){
        return _marcaRepository.getOne(id);
    }


    public Marca alterarMarca(Long id, Marca marca){
        _marcaRepository.deleteById(id);
        marca = _marcaRepository.save(marca);
        return marca;
    }

    public void excluirMarca(Long id){
        _marcaRepository.deleteById(id);
    }

    public Optional<Marca> buscarMarca(Long id){
        Optional<Marca> marca;
        marca = _marcaRepository.findById(id);
        return marca;
    }
    /*
    * Será necessário implementar a lógica para alterar, excluir e buscar motorista.
    *
    * Ao final, implemente também o mesmo para Marca e Carro
    *
    * */
}
