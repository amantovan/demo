package com.example.demo.business;

import com.example.demo.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VendedorBusiness extends BaseBusiness<Vendedor>{

    VendedorBusiness(JpaRepository<Vendedor, Long> repository) {
        super(repository);
    }
}
