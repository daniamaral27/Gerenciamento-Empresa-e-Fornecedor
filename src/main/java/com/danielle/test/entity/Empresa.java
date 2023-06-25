package com.danielle.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_test")
@NoArgsConstructor
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "cep", nullable = false)
    private Integer cep;

    @Builder
    public Empresa(String name, String cnpj, Integer cep) {
        this.name = name;
        this.cnpj = cnpj;
        this.cep = cep;
    }

}
