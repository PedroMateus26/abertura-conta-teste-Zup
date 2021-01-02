package com.ContaBancoZup.projetoTeste.dto;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;
import com.ContaBancoZup.projetoTeste.services.exception.DadosBancariosValid;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@DadosBancariosValid
public class DadosPessoaisContaBancariaDTO {
    private Long id;
    private String nome;

    @Email(message = "Favor entrar com email válido")
    @NotBlank(message = "Campo email obrigatório")
    private String email;

    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;
    private String dataNascimento;

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
