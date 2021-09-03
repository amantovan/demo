package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "vendedor")
@Getter
@Setter
public class Vendedor extends EntidadeBase{

    @NotBlank
    private String cpf;

    @Embedded
    @JsonUnwrapped
    private PosicaoGeografica posicaoGeografica;

}
