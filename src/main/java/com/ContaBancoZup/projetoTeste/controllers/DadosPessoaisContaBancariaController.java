package com.ContaBancoZup.projetoTeste.controllers;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.services.DadosPessoaisContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/dados")
public class DadosPessoaisContaBancariaController {

        @Autowired
        private DadosPessoaisContaBancariaService dadosPessoaisContaBancariaService;

        @GetMapping
        public ResponseEntity<List<DadosPessoaisContaBancaria>> findAll(){
            List<DadosPessoaisContaBancaria> list=dadosPessoaisContaBancariaService.findAll();
            return ResponseEntity.ok().body(list);
        }

}
