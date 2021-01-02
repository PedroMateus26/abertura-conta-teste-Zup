package com.ContaBancoZup.projetoTeste.entities;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tb_dados_pessoais")
public class DadosPessoaisContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;


    private String dataNascimento;
    //Caso o desenvolvedor queira utilizar datas com valores de datas e não string
    //Basta descomentar as duas linhas abaixo, comentar a data de nascimento acima
    //Deve ser feito as mudanças necessárias nos get e set e nos contrutores
    //@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    //private LocalDate dataNascimento;

    public DadosPessoaisContaBancaria() {
    }

    public DadosPessoaisContaBancaria(Long id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
