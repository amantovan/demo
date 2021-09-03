package com.example.demo.business;

import com.example.demo.model.Marca;
import com.example.demo.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaBusiness {

    @Autowired
    private MarcaRepository _marcaRepository;

    public Marca criarMarca(Marca marca) {
        marca = _marcaRepository.save(marca);
        return marca;
    }

    public Marca buscarMarca(Long id){
        Marca marca;
        marca = _marcaRepository.findById(id).get();
        return marca;
    }

    public List<Marca> listarTodos() {
        return _marcaRepository.findAll();
    }


    public Marca alterarMarca(Long id, Marca marca){
        marca.setId(id);
        marca = _marcaRepository.save(marca);
        return marca;
    }

    public void excluirMarca(Long id){
        _marcaRepository.deleteById(id);
    }

}
