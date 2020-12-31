package com.ContaBancoZup.projetoTeste.repositories;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosPessoaisContaBancariaRepository
        extends JpaRepository<DadosPessoaisContaBancaria,Long> {

    DadosPessoaisContaBancaria findByEmail(String email);
    DadosPessoaisContaBancaria findByCpf(String cpf);


}
