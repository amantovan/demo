package com.example.demo.repository;

import com.example.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByVendedor_Id(Long id);

    List<Cliente> findByRazaoSocial(String razaoSocial);
}
//select cliente0_.id, cliente0_.cnpj, cliente0_.latitude, cliente0_.longitude, cliente0_.razao_social, cliente0_.vendedor_id from cliente cliente0_ left outer join vendedor vendedor1_ on cliente0_.vendedor_id=vendedor1_.id where vendedor1_.id=?
