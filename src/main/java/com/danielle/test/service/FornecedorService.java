package com.danielle.test.service;

import java.util.List;

import com.danielle.test.dto.request.FornecedorRequestDTO;
import com.danielle.test.dto.response.FornecedorResponseDTO;

public interface FornecedorService {

    FornecedorResponseDTO findById(Long id);

    List<FornecedorResponseDTO> findAll();

    FornecedorResponseDTO register(FornecedorRequestDTO FornecedorDTO);

    FornecedorResponseDTO update(Long id, FornecedorRequestDTO FornecedorDTO);

    String delete(Long id);

}
