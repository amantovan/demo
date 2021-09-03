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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "fabricacao")
    private Integer fabricacao;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "cor")
    private String cor;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
}
