package com.example.demo.controller;

import com.example.demo.business.BaseBusiness;
import com.example.demo.business.ClienteBusiness;
import com.example.demo.model.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController extends BaseController<Cliente>{

    public ClienteController(@Qualifier("clienteBusiness") BaseBusiness<Cliente> business) {
        super(business);
    }
}
