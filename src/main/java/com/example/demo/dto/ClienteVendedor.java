package com.example.demo.dto;

import lombok.Data;

@Data
public class ClienteVendedor {

    private Long codCliente;

    private String razaoSocial;

    private Long codVendedor;

    private String nomeVendedor;

    private String distancia;

    public void setDistancia(Double distancia) {
        this.distancia = round(distancia, 2).toString().concat(" metros");

    }
    private Double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
