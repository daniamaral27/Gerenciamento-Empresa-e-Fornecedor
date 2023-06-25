package com.danielle.test.service;


import java.util.List;

import com.danielle.test.dto.request.EmpresaRequestDTO;
import com.danielle.test.dto.response.EmpresaResponseDTO;

public interface EmpresaService {

    EmpresaResponseDTO findById(Long id);

    List<EmpresaResponseDTO> findAll();

    EmpresaResponseDTO register(EmpresaRequestDTO EmpresaDTO);

    EmpresaResponseDTO update(Long id, EmpresaRequestDTO EmpresaDTO);

    String delete(Long id);

}

