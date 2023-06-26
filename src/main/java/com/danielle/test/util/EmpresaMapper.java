package com.danielle.test.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.danielle.test.dto.request.EmpresaRequestDTO;
import com.danielle.test.dto.response.EmpresaResponseDTO;
import com.danielle.test.entity.Empresa;

@Component
public class EmpresaMapper {

    public Empresa toEmpresa(EmpresaRequestDTO EmpresaDTO) {

        return Empresa.builder()
                .nameFantasia(EmpresaDTO.getName())
                .cnpj(EmpresaDTO.getCnpj())
                .cep(EmpresaDTO.getCep())
                .build();

    }

    public EmpresaResponseDTO toEmpresaDTO(Empresa Empresa) {
        return new EmpresaResponseDTO(Empresa);
    }

    public List<EmpresaResponseDTO> toPeopleDTO(List<Empresa> peopleList) {
        return peopleList.stream().map(EmpresaResponseDTO::new).collect(Collectors.toList());
    }

    public void updateEmpresaData(Empresa Empresa, EmpresaRequestDTO EmpresaDTO) {

        Empresa.setName(EmpresaDTO.getName());
        Empresa.setCnpj(EmpresaDTO.getCnpj());
        Empresa.setCep(EmpresaDTO.getCep());

    }

}
