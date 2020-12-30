package com.ContaBancoZup.projetoTeste.controllers;

import com.ContaBancoZup.projetoTeste.dto.DadosPessoaisContaBancariaDTO;
import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.services.DadosPessoaisContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/dados")
public class DadosPessoaisContaBancariaController {

    @Autowired
    private DadosPessoaisContaBancariaService dadosPessoaisContaBancariaService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisContaBancariaDTO>> findAll() {
        List<DadosPessoaisContaBancariaDTO> list = dadosPessoaisContaBancariaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO> findById(@PathVariable Long id) {
        DadosPessoaisContaBancariaDTO dto = dadosPessoaisContaBancariaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisContaBancariaDTO>
    insert(@Valid @RequestBody DadosPessoaisContaBancariaDTO dto) {
        dto= dadosPessoaisContaBancariaService.insert(dto);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO>
    insert(@PathVariable Long id,@RequestBody DadosPessoaisContaBancariaDTO dto) {
        dto= dadosPessoaisContaBancariaService.update(dto,id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO>delete(@PathVariable Long id) {
        dadosPessoaisContaBancariaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
