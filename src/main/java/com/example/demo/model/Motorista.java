package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "motorista", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carro> carros;
}
