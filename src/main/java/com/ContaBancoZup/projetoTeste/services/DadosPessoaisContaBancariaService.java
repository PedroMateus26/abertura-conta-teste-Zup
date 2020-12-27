package com.ContaBancoZup.projetoTeste.services;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.repositories.DadosPessoaisContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisContaBancariaService {

    @Autowired
    private DadosPessoaisContaBancariaRepository dadosPessoaisContaBancariaRepository;

    public List<DadosPessoaisContaBancaria> findAll (){
        return dadosPessoaisContaBancariaRepository.findAll();
    }

}
