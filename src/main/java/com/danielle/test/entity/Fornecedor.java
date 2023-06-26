package com.danielle.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fornecedor")
@NoArgsConstructor
@Getter
@Setter
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
   
    @Column(name = "cnpj_cpf", nullable = false, unique = true)
    private String cnpj_cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cep", nullable = false)
    private Integer cep;

    @Builder
    public Fornecedor(String name, String cnpj_cpf, String email, Integer cep) {
        this.name = name;
        this.cnpj_cpf = cnpj_cpf;
        this.email = email;
        this.cep = cep;
       
    }
    
}
