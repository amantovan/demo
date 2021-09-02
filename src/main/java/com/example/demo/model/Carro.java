package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "carro")
@Getter
@Setter
public class Carro {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    private String modelo;
    private Integer fabricacao;
    private Integer ano;
    private String cor;


}
