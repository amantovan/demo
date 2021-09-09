package com.example.demo.business;

import com.example.demo.filters.DistribuicaoFilter;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteBusiness extends BaseBusiness<Cliente> {


    @Autowired
    VendedorBusiness vendedorBusiness;

    @Autowired
    ClienteRepository clienteRepository;

    ClienteBusiness(JpaRepository<Cliente, Long> repository) {
        super(repository);
    }


    public List<Cliente> listarTodos(DistribuicaoFilter distribuicaoFilter) {
        Sort ordenarPorCodigoCliente = null;

        if (distribuicaoFilter.getType() != null) {
            if (distribuicaoFilter.getType().equals("codigoCliente")) {
                List<Cliente> clientes = new java.util.ArrayList<>(Collections.emptyList());
                Optional<Cliente> cliente = repository.findById(Long.valueOf(distribuicaoFilter.getArg()));
                cliente.ifPresent(cliente1 -> clientes.add(0, cliente1));
                return clientes;
            } else if (distribuicaoFilter.getType().equals("razaoSocial")) {
                return clienteRepository.findByRazaoSocial(distribuicaoFilter.getArg());
            } else if (distribuicaoFilter.getType().equals("codigoVendedor")) {
                return clienteRepository.findByVendedor_Id(Long.valueOf(distribuicaoFilter.getArg()));
            }
        }

        if ( distribuicaoFilter.getClassificacao().equals("codigoCliente") ) {
            if ( distribuicaoFilter.getOrd().equals("asc") ) {
                ordenarPorCodigoCliente = Sort.by(Sort.Order.asc("id"));
            } else if ( distribuicaoFilter.getOrd().equals("desc") ){
                ordenarPorCodigoCliente = Sort.by(Sort.Order.desc("id"));
            }


            return repository.findAll(ordenarPorCodigoCliente);
        }else if ( distribuicaoFilter.getClassificacao().equals("razaoSocial") ) {
            Sort ordenarPorRazaoSocial = null;
            if ( distribuicaoFilter.getOrd().equals("asc") ) {
                ordenarPorRazaoSocial = Sort.by(Sort.Order.asc("razaoSocial"));
            } else if ( distribuicaoFilter.getOrd().equals("desc") ){
                ordenarPorRazaoSocial = Sort.by(Sort.Order.desc("razaoSocial"));
            }
            return repository.findAll(ordenarPorRazaoSocial);
        }
        return null;
    }

    public ResponseEntity criar(Cliente c) {
        if (this.existeCNPJ(c)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            } else {
            c = repository.save(c);
            return ResponseEntity.ok(c);
        }
    }


    public ResponseEntity alterar(Long id, Cliente c){
        if (this.existeCNPJ(c) && !id.equals(c.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            } else {
            c.setId(id);
            c = repository.save(c);
            return ResponseEntity.ok(c);
        }
    }

    private boolean existeCNPJ(Cliente c){
        for (Long i = Long.valueOf(1); i <= repository.count(); i++) {
            if (c.getCnpj().equals(repository.findById(i).get().getCnpj())) {
                return true;
            }
        }
        return false;
    }
}
