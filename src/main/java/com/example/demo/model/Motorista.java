package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "motorista")
@Getter
@Setter
public class Motorista {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private LocalDate dataDeNasc;

    @OneToMany(mappedBy = "id", targetEntity = Carro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Carro> carros;



}
