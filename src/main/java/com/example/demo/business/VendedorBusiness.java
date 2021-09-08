package com.example.demo.business;

import com.example.demo.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendedorBusiness extends BaseBusiness<Vendedor>{


    VendedorBusiness(JpaRepository<Vendedor, Long> repository) {
        super(repository);
    }

    public ResponseEntity criar(Vendedor v) {
        if (this.existeCPF(v)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            } else {
            v = repository.save(v);
            return ResponseEntity.ok(v);
        }
    }

    public ResponseEntity alterar(Long id, Vendedor v){
        if (this.existeCPF(v)  && (!v.getId().equals(id))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
        v.setId(id);
        v = repository.save(v);
        return ResponseEntity.ok(v);
        }
    }

    private boolean existeCPF(Vendedor v){
        for (Long i = Long.valueOf(1); i <= repository.count(); i++) {
            if (v.getCpf().equals(repository.findById(i).get().getCpf())) {
                return true;
            }
        }
        return false;
    }
}
