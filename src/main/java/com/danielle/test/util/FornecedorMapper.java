package com.danielle.test.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.danielle.test.dto.request.FornecedorRequestDTO;
import com.danielle.test.dto.response.FornecedorResponseDTO;
import com.danielle.test.entity.Fornecedor;

@Component
public class FornecedorMapper {
       public Fornecedor toFornecedor(FornecedorRequestDTO FornecedorDTO) {

        return Fornecedor.builder()
                .name(FornecedorDTO.getName())
                .cnpj_cpf(FornecedorDTO.getCnpj_cpf())
                .email(FornecedorDTO.getEmail())
                .cep(FornecedorDTO.getCep())
                .build();

    }

    public FornecedorResponseDTO toFornecedorDTO(Fornecedor Fornecedor) {
        return new FornecedorResponseDTO(Fornecedor);
    }

    public List<FornecedorResponseDTO> toPeopleDTO(List<Fornecedor> peopleList) {
        return peopleList.stream().map(FornecedorResponseDTO::new).collect(Collectors.toList());
    }

    public void updateFornecedorData(Fornecedor Fornecedor, FornecedorRequestDTO FornecedorDTO) {

        Fornecedor.setName(FornecedorDTO.getName());
        Fornecedor.setCnpj_cpf(FornecedorDTO.getCnpj_cpf());
        Fornecedor.setEmail(FornecedorDTO.getEmail());
        Fornecedor.setCep(FornecedorDTO.getCep());

    }
}
