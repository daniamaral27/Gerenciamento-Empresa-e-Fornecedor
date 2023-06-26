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

import com.danielle.test.dto.request.FornecedorRequestDTO;
import com.danielle.test.dto.response.FornecedorResponseDTO;
import com.danielle.test.service.FornecedorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/Fornecedor")
@RequiredArgsConstructor

public class FornecedorController {

    private final FornecedorService fornecedorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(fornecedorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> findAll() {
        return ResponseEntity.ok().body(fornecedorService.findAll());
    }

    @PostMapping
    public ResponseEntity<FornecedorResponseDTO> register(@RequestBody FornecedorRequestDTO FornecedorRequestDTO, UriComponentsBuilder uriBuilder) {

        FornecedorResponseDTO FornecedorResponseDTO = fornecedorService.register(FornecedorRequestDTO);

        URI uri = uriBuilder.path("/TestApi/{id}").buildAndExpand(FornecedorResponseDTO.getId()).toUri();

      return ResponseEntity.created(uri).body(FornecedorResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorResponseDTO> update(@RequestBody FornecedorRequestDTO FornecedorDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(fornecedorService.update(id, FornecedorDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(fornecedorService.delete(id));
    }

    
}
