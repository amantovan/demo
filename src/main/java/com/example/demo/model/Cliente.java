package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente extends EntidadeBase{

    @NotBlank
    @Column(name = "cnpj")
    private String cnpj;

    @NotBlank
    @Column(name = "razao_social")
    private String razaoSocial;

    @Embedded
    @JsonUnwrapped
    private PosicaoGeografica posicaoGeografica;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    @JsonIgnore
    private Vendedor vendedor;


}
