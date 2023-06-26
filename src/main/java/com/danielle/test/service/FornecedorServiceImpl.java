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

    private final FornecedorRepository FornecedorRepository;

    private final FornecedorMapper FornecedorMapper;


    @Override
    public FornecedorResponseDTO findById(Long id) {
     return FornecedorMapper.toFornecedorDTO(returnFornecedor(id));
    }

    @Override
    public List<FornecedorResponseDTO> findAll() {
        return FornecedorMapper.toPeopleDTO(FornecedorRepository.findAll());
    }

    @Override
    public FornecedorResponseDTO register(FornecedorRequestDTO FornecedorDTO) {

        Fornecedor Fornecedor = FornecedorMapper.toFornecedor(FornecedorDTO);

        return FornecedorMapper.toFornecedorDTO(FornecedorRepository.save(Fornecedor));
    }

    @Override
    public FornecedorResponseDTO update(Long id, FornecedorRequestDTO FornecedorDTO) {

        Fornecedor Fornecedor = returnFornecedor(id);

        FornecedorMapper.updateFornecedorData(Fornecedor, FornecedorDTO);

        return FornecedorMapper.toFornecedorDTO(FornecedorRepository.save(Fornecedor));
    }

    @Override
    public String delete(Long id) {
        FornecedorRepository.deleteById(id);
        return "Fornecedor id: "+id+" deleted";
    }

    private Fornecedor returnFornecedor(Long id) {
       return FornecedorRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Fornecedor wasn't fount on database"));
    }

}