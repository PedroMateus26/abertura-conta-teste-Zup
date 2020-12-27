package com.ContaBancoZup.projetoTeste.dto;

import com.ContaBancoZup.projetoTeste.entities.DadosPessoaisContaBancaria;

public class DadosPessoaisContaBancariaDTO {
    private Long id;
    private String nome;
    private String email;
    private Integer cpf;
    private Integer dataNascimento;

    public DadosPessoaisContaBancariaDTO() {
    }

    public DadosPessoaisContaBancariaDTO(Long id, String nome, String email, Integer cpf, Integer dataNascimento) {
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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
