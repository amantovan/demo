package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "vendedor")
@Getter
@Setter
public class Vendedor extends EntidadeBase{

    @NotBlank
    private String cpf;

    @NotBlank
    private String nome;

    @Embedded
    @JsonUnwrapped
    private PosicaoGeografica posicaoGeografica;

}
