package com.ContaBancoZup.projetoTeste.dto;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.services.exception.DadosBancariosValid;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

@DadosBancariosValid
public class DadosPessoaisContaBancariaDTO {
    private Long id;

    @Size(min = 5, max = 60, message = "O nome deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Email(message = "Favor entrar com email válido")
    @NotBlank(message = "Campo email obrigatório")
    private String email;

    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;

    private String dataNascimento;
    //Caso o desenvolvedor queira utilizar datas com valores de datas e não string
    //Basta descomentar as duas linhas abaixo, comentar a data de nascimento acima
    //Deve ser feito as mudanças necessárias nos get e set e nos contrutores
    //@PastOrPresent(message = "A data do produto não pode ser futura")
    //private LocalDate dataNascimento;


    public DadosPessoaisContaBancariaDTO() {
    }

    public DadosPessoaisContaBancariaDTO(Long id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public DadosPessoaisContaBancariaDTO(DadosPessoaisContaBancaria entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
        cpf = entity.getCpf();
        dataNascimento = entity.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
