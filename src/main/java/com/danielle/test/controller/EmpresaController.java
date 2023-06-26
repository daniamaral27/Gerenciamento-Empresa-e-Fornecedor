package com.danielle.test.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielle.test.dto.request.EmpresaRequestDTO;
import com.danielle.test.dto.response.EmpresaResponseDTO;
import com.danielle.test.service.EmpresaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/Empresa")
@RequiredArgsConstructor

public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(empresaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(empresaService.findAll());
    }

    @PostMapping
    public ResponseEntity<EmpresaResponseDTO> register(@RequestBody EmpresaRequestDTO EmpresaRequestDTO, UriComponentsBuilder uriBuilder) {

        EmpresaResponseDTO EmpresaResponseDTO = empresaService.register(EmpresaRequestDTO);

        URI uri = uriBuilder.path("/TestApi/{id}").buildAndExpand(EmpresaResponseDTO.getId()).toUri();

      return ResponseEntity.created(uri).body(EmpresaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaResponseDTO> update(@RequestBody EmpresaRequestDTO EmpresaDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(empresaService.update(id,EmpresaDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(empresaService.delete(id));
    }

}

