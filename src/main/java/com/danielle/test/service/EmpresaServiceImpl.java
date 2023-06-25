package com.danielle.test.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.danielle.test.dto.request.EmpresaRequestDTO;
import com.danielle.test.dto.response.EmpresaResponseDTO;
import com.danielle.test.entity.Empresa;
import com.danielle.test.repository.EmpresaRepository;
import com.danielle.test.util.EmpresaMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor


public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    private final EmpresaMapper empresaMapper;


    @Override
    public EmpresaResponseDTO findById(Long id) {
     return empresaMapper.toEmpresaDTO(returnEmpresa(id));
    }

    @Override
    public List<EmpresaResponseDTO> findAll() {
        return empresaMapper.toPeopleDTO(empresaRepository.findAll());
    }

    @Override
    public EmpresaResponseDTO register(EmpresaRequestDTO empresaDTO) {

        Empresa empresa = empresaMapper.toEmpresa(empresaDTO);

        return empresaMapper.toEmpresaDTO(empresaRepository.save(empresa));
    }

    @Override
    public EmpresaResponseDTO update(Long id, EmpresaRequestDTO empresaDTO) {

        Empresa empresa = returnEmpresa(id);

        empresaMapper.updateEmpresaData(empresa, empresaDTO);

        return empresaMapper.toEmpresaDTO(empresaRepository.save(empresa));
    }

    @Override
    public String delete(Long id) {
        empresaRepository.deleteById(id);
        return "Empresa id: "+id+" deleted";
    }

    private Empresa returnEmpresa(Long id) {
       return empresaRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Empresa wasn't fount on database"));
    }

}