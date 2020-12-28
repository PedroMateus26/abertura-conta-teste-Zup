package com.ContaBancoZup.projetoTeste.services;

import com.ContaBancoZup.projetoTeste.dto.DadosPessoaisContaBancariaDTO;
import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.repositories.DadosPessoaisContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DadosPessoaisContaBancariaService {

    @Autowired
    private DadosPessoaisContaBancariaRepository dadosPessoaisContaBancariaRepository;

    public List<DadosPessoaisContaBancariaDTO> findAll() {
        List<DadosPessoaisContaBancaria> list=dadosPessoaisContaBancariaRepository.findAll();
        List<DadosPessoaisContaBancariaDTO> listDTO=list.stream()
                .map(elem->new DadosPessoaisContaBancariaDTO(elem))
                .collect(Collectors.toList());
        return listDTO;
    }

    public DadosPessoaisContaBancariaDTO findById(Long id) {
        Optional<DadosPessoaisContaBancaria> obj=dadosPessoaisContaBancariaRepository.findById(id);
        DadosPessoaisContaBancaria entity=obj.get();
        return new DadosPessoaisContaBancariaDTO(entity);
    }

     public DadosPessoaisContaBancariaDTO insert(DadosPessoaisContaBancariaDTO dto){
        DadosPessoaisContaBancaria entity= converteDTOEntidade(dto);
        entity=dadosPessoaisContaBancariaRepository.save(entity);
        return new DadosPessoaisContaBancariaDTO(entity);
    }

    public DadosPessoaisContaBancariaDTO update(DadosPessoaisContaBancariaDTO dto, Long id) {
            DadosPessoaisContaBancaria entity=dadosPessoaisContaBancariaRepository.getOne(id);
            entity=converteDTOEntidade(dto);
            entity=dadosPessoaisContaBancariaRepository.save(entity);
            return new DadosPessoaisContaBancariaDTO(entity);
    }

    public void delete(Long id) {
        dadosPessoaisContaBancariaRepository.deleteById(id);
    }

    private DadosPessoaisContaBancaria converteDTOEntidade(DadosPessoaisContaBancariaDTO dto) {
        DadosPessoaisContaBancaria entity=new DadosPessoaisContaBancaria();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }



}
