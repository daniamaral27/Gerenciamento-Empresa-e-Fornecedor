package com.danielle.test.dto.response;

import com.danielle.test.entity.Fornecedor;

import lombok.Getter;

@Getter
public class FornecedorResponseDTO {

    private Long id;

    private String name;

    private String Cnpj_cpf;

    private String email;
    
    private Integer cep;

    public FornecedorResponseDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.name = fornecedor.getName();
        this.Cnpj_cpf = fornecedor.getCnpj_cpf();
        this.email = fornecedor.getEmail();
        this.cep = fornecedor.getCep();
    }


}