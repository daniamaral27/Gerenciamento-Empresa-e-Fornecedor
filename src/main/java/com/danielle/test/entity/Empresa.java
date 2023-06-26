package com.danielle.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresa")
@NoArgsConstructor
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "nameFantasia", nullable = false)
    private String nameFantasia;

    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name = "cep", nullable = false)
    private Integer cep;

    @Builder
    public Empresa(String nameFantasia, String cnpj, Integer cep) {
        this.nameFantasia = nameFantasia;
        this.cnpj = cnpj;
        this.cep = cep;
    }

}
