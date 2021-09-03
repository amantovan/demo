package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Embeddable
@Getter
@Setter
public class PosicaoGeografica {

    @NotBlank
    @Min(-90)
    @Max(90)
    @Column(name = "latitude")
    private String latitude;

    @NotBlank
    @Min(-180)
    @Max(180)
    @Column(name = "longitude")
    private String longitude;

}
