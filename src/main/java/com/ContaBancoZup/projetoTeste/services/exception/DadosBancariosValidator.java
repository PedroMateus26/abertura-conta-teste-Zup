package com.ContaBancoZup.projetoTeste.services.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ContaBancoZup.projetoTeste.controllers.exceptions.FieldMessage;
import com.ContaBancoZup.projetoTeste.dto.DadosPessoaisContaBancariaDTO;
import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.repositories.DadosPessoaisContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DadosBancariosValidator
        implements ConstraintValidator<DadosBancariosValid,
        DadosPessoaisContaBancariaDTO>{

    @Autowired
    private DadosPessoaisContaBancariaRepository repository;

    @Override
    public void initialize(DadosBancariosValid constraintAnnotation) {

    }

    @Override
    public boolean
    isValid(DadosPessoaisContaBancariaDTO dadosPessoaisContaBancariaDTO
            , ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();
        DadosPessoaisContaBancaria testeEmail=
                repository.findByEmail(dadosPessoaisContaBancariaDTO.getEmail());

        DadosPessoaisContaBancaria testeCpf=
                repository.findByCpf(dadosPessoaisContaBancariaDTO.getCpf());

        if(testeEmail!=null){
            list.add(new FieldMessage
                    ("email","Já existe alguém cadastrado com esse email"));
        }
        if(testeCpf!=null){
            list.add(new FieldMessage
                    ("cpf","Já existe alguém cadastrado com esse cpf"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
