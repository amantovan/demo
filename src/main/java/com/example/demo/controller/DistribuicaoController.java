package com.example.demo.controller;

import com.example.demo.business.DistribuicaoBusiness;
import com.example.demo.filters.DistribuicaoFilter;
import com.example.demo.dto.ClienteVendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/distribuir")
public class DistribuicaoController {

    @Autowired
    DistribuicaoBusiness distribuicaoBusiness;

    @GetMapping
    public List<ClienteVendedor> distribuir(DistribuicaoFilter filter) {
        System.out.println(filter.toString());
        return this.distribuicaoBusiness.distribuir(filter);
    }
}
