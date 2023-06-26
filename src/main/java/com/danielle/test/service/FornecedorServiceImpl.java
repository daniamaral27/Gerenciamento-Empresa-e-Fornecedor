package com.danielle.test.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.danielle.test.dto.request.FornecedorRequestDTO;
import com.danielle.test.dto.response.FornecedorResponseDTO;
import com.danielle.test.entity.Fornecedor;
import com.danielle.test.repository.FornecedorRepository;
import com.danielle.test.util.FornecedorMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor


public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    private final FornecedorMapper fornecedorMapper;


    @Override
    public FornecedorResponseDTO findById(Long id) {
     return fornecedorMapper.toFornecedorDTO(returnFornecedor(id));
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return fornecedorMapper.toPeopleDTO(fornecedorRepository.findAll());
    }

    @Override
    public FornecedorResponseDTO register(FornecedorRequestDTO fornecedorDTO) {

        Fornecedor fornecedor = fornecedorMapper.toFornecedor(fornecedorDTO);

        return fornecedorMapper.toFornecedorDTO(fornecedorRepository.save(fornecedor));
    }

    @Override
    public FornecedorResponseDTO update(Long id, FornecedorRequestDTO fornecedorDTO) {

        Fornecedor fornecedor = returnFornecedor(id);

        fornecedorMapper.updateFornecedorData(fornecedor, fornecedorDTO);

        return fornecedorMapper.toFornecedorDTO(fornecedorRepository.save(fornecedor));
    }

    @Override
    public String delete(Long id) {
        fornecedorRepository.deleteById(id);
        return "Fornecedor id: "+id+" deleted";
    }

    private Fornecedor returnFornecedor(Long id) {
       return fornecedorRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Fornecedor wasn't fount on database"));
    }

}