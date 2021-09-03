package com.example.demo.business;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteBusiness extends BaseBusiness<Cliente> {

    ClienteBusiness(JpaRepository<Cliente, Long> repository) {
        super(repository);
    }
}
