package com.ContaBancoZup.projetoTeste.services;

import com.ContaBancoZup.projetoTeste.dto.DadosPessoaisContaBancariaDTO;
import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.exceptions.DataBaseException;
import com.ContaBancoZup.projetoTeste.exceptions.ResourceNotFoundException;
import com.ContaBancoZup.projetoTeste.repositories.DadosPessoaisContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DadosPessoaisContaBancariaService {

    @Autowired
    private DadosPessoaisContaBancariaRepository dadosPessoaisContaBancariaRepository;

    @Transactional(readOnly = true)
    public List<DadosPessoaisContaBancariaDTO> findAll() {
        List<DadosPessoaisContaBancaria> list = dadosPessoaisContaBancariaRepository.findAll();
        List<DadosPessoaisContaBancariaDTO> listDTO = list.stream()
                .map(elem -> new DadosPessoaisContaBancariaDTO(elem))
                .collect(Collectors.toList());
        return listDTO;
    }

    //Para busca paginada
    /*
    @Transactional(readOnly = true)
	public Page<DadosPessoaisContaBancariaDTO> findAllPaged(PageRequest pageRequest) {
		Page<DadosPessoaisContaBancaria> list = dadosPessoaisContaBancariaRepository
		    .findAll(pageRequest);
		return list.map(x -> new DadosPessoaisContaBancariaDTO(x));
	}
    */

    @Transactional(readOnly = true)
    public DadosPessoaisContaBancariaDTO findById(Long id) {
        Optional<DadosPessoaisContaBancaria> obj = dadosPessoaisContaBancariaRepository.findById(id);
        DadosPessoaisContaBancaria entity = obj.orElseThrow(() ->
                new ResourceNotFoundException("Entitiy not found"));
        return new DadosPessoaisContaBancariaDTO(entity);


    }

    @Transactional
    public DadosPessoaisContaBancariaDTO insert(DadosPessoaisContaBancariaDTO dto) {
        DadosPessoaisContaBancaria entity = converteDTOEntidade(dto);
        entity = dadosPessoaisContaBancariaRepository.save(entity);
        return new DadosPessoaisContaBancariaDTO(entity);
    }

    @Transactional
    public DadosPessoaisContaBancariaDTO update(DadosPessoaisContaBancariaDTO dto, Long id) {
        try {
            DadosPessoaisContaBancaria entity = dadosPessoaisContaBancariaRepository.getOne(id);
            entity = converteDTOEntidade(dto);
            entity = dadosPessoaisContaBancariaRepository.save(entity);
            return new DadosPessoaisContaBancariaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        dadosPessoaisContaBancariaRepository.deleteById(id);
        try {
            dadosPessoaisContaBancariaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found" + id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity violation");
        }
    }

    private DadosPessoaisContaBancaria converteDTOEntidade(DadosPessoaisContaBancariaDTO dto) {
        DadosPessoaisContaBancaria entity = new DadosPessoaisContaBancaria();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }


}
