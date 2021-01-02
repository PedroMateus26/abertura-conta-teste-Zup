import axios from "axios";
import { stat } from "fs";
import React, { useEffect, useState } from "react";
import { Map } from "typescript";
import ActionButton from "../core/components/ActionButton";
import { ErrorData } from "../core/types/ErrorData";
import { UserData } from "../core/types/UserData";
import { makeRequest } from "../core/utils/request";
import "./styles.css";

const DadosBancarios = () => {
  const [status, setStatus] = useState<number>(0);
  const [name, setName] = useState("");
  const [erro, setErro] = useState<string[]>();
  const [cpf, setCpf] = useState("");
  const [email, setEmail] = useState("");
  const [dataNascimento, setDataNascimento] = useState("");
  const [userData, setUserData] = useState<UserData>();
  let listError: string[] = [];

  const handleOnChangeName = (event: React.ChangeEvent<HTMLInputElement>) => {
    setName(event.target.value);
  };
  const handleOnChangeEmail = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(event.target.value);
  };
  const handleOnChangeCpf = (event: React.ChangeEvent<HTMLInputElement>) => {
    setCpf(event.target.value);
  };
  const handleOnChangedataNascimento = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setDataNascimento(event.target.value);
  };

  const handleOnClick = () => {
    setUserData({
      nome: name,
      email,
      cpf,
      dataNascimento,
    });

    makeRequest({ url: "dados", method: "POST", data: userData })
      .then((response) => [
        console.log(response.data, response.status),
        setStatus(response.status),
      ])
      .catch((err) => {
        const { errors } = err.response.data; //Pega a lista de erro
        listError = [];
        if (errors !== undefined) {
          for (const { message } of errors) {
            //extrai mensagem de erro de dentro de cada elemento da lista
            listError.push(message);
          }
          setStatus(422);
          setErro(listError);
        }
      });
    if (status === 422) {
      console.log(erro);
    }
  };

  return (
    <div>
      <div className="container">
        <h1 className="title">Entre com os dados do cliente</h1>
        <input
          placeholder="Nome do Cliente"
          type="text"
          value={name}
          className="input-text"
          onChange={handleOnChangeName}
        />
        <input
          placeholder="Email"
          type="text"
          value={email}
          className="input-text"
          onChange={handleOnChangeEmail}
        />
        <input
          placeholder="CPF"
          type="text"
          value={cpf}
          className="input-text"
          onChange={handleOnChangeCpf}
        />
        <input
          placeholder="Data de Nascimento"
          type="text"
          value={dataNascimento}
          className="input-text"
          onChange={handleOnChangedataNascimento}
        />
        <ActionButton title="Salvar" onClick={handleOnClick} />
      </div>
      {status === 201 && <h1 className="return-message">Usuário criado com sucesso</h1>}
      {status === 422 && erro?.map((elem) => <h2 key={elem} className="return-message">Erro: {elem}</h2>)}
    </div>
  );
};

export default DadosBancarios;
