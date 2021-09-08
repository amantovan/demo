package com.example.demo.business;

import com.example.demo.model.Cliente;
import com.example.demo.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteBusiness extends BaseBusiness<Cliente> {


    @Autowired
    VendedorBusiness vendedorBusiness;

    ClienteBusiness(JpaRepository<Cliente, Long> repository) {
        super(repository);
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
