package com.example.demo.controller;

import com.example.demo.business.ClienteBusiness;
import com.example.demo.business.VendedorBusiness;
import com.example.demo.model.Cliente;
import com.example.demo.model.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/exportar")
public class ExportacaoController {

    @Autowired
    ClienteBusiness clienteBusiness;

    @Autowired
    VendedorBusiness vendedorBusiness;

    @GetMapping(name = "/cliente")
    public List<Cliente> buscarClientes() {
        return clienteBusiness.listarTodos();
    }

    @GetMapping(name = "/vendedor")
    public List<Vendedor> buscarVendedores() {
        return vendedorBusiness.listarTodos();
    }
}
