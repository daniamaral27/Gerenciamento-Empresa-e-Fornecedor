package com.danielle.test.dto.response;

import com.danielle.test.entity.Empresa;

import lombok.Getter;

@Getter
public class EmpresaResponseDTO {

    private Long id;

    private String nameFantasia;


    private String Cnpj;


    private Integer cep;

    public EmpresaResponseDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nameFantasia = empresa.getNameFantasia();
        this.Cnpj = empresa.getCnpj();
        this.cep = empresa.getCep();
    }


}
