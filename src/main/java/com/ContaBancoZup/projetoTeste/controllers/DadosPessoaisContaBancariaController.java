package com.ContaBancoZup.projetoTeste.controllers;

import com.ContaBancoZup.projetoTeste.dto.DadosPessoaisContaBancariaDTO;
import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.services.DadosPessoaisContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/dados")
public class DadosPessoaisContaBancariaController {

    @Autowired
    private DadosPessoaisContaBancariaService dadosPessoaisContaBancariaService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisContaBancariaDTO>> findAll() {
        List<DadosPessoaisContaBancariaDTO> list = dadosPessoaisContaBancariaService.findAll();
        return ResponseEntity.ok().body(list);
    }


    //Para busca paginada, basta comentar a busca de todos elementos no método acima
    // e descomenta o método baixo
    //O mesmo deve ser feito na camada de serviço
    /*@GetMapping
	public ResponseEntity<Page<DadosPessoaisContaBancariaDTO>> findAll
                            (@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "firstName") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		Page<DadosPessoaisContaBancariaDTO> list = dadosPessoaisContaBancariaService
                .findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
    */

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO> findById(@PathVariable Long id) {
        DadosPessoaisContaBancariaDTO dto = dadosPessoaisContaBancariaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisContaBancariaDTO>
    insert(@Valid @RequestBody DadosPessoaisContaBancariaDTO dto) {
        dto = dadosPessoaisContaBancariaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO>
    insert(@PathVariable Long id, @RequestBody DadosPessoaisContaBancariaDTO dto) {
        dto = dadosPessoaisContaBancariaService.update(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DadosPessoaisContaBancariaDTO> delete(@PathVariable Long id) {
        dadosPessoaisContaBancariaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
