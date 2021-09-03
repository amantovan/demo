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
@Table(name = "cliente")
@Getter
@Setter
public class Cliente extends EntidadeBase{

    @NotBlank
    @Column(name = "cnpj")
    @Min(14)
    @Max(14)
    private String cnpj;

    @NotBlank
    @Column(name = "razao_social")
    private String razaoSocial;

    @Embedded
    @JsonUnwrapped
    private PosicaoGeografica posicaoGeografica;

}
