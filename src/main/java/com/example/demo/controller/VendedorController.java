package com.example.demo.controller;

import com.example.demo.business.BaseBusiness;
import com.example.demo.business.VendedorBusiness;
import com.example.demo.model.Vendedor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController extends BaseController<Vendedor>{

    public VendedorController(@Qualifier("vendedorBusiness") BaseBusiness<Vendedor> business) {
        super(business);
    }
}
