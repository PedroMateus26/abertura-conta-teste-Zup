import axios from "axios";
import React, { useEffect, useState } from "react";
import ActionButton from "../core/components/ActionButton";
import { UserData } from "../core/types/UserData";
import { makeRequest } from "../core/utils/request";
import "./styles.css";

const DadosBancarios = () => {
  const [status, setStatus] = useState<number>(0);
  const [name, setName] = useState("");
  const [cpf, setCpf] = useState("");
  const [email, setEmail] = useState("");
  const [dataNascimento, setDataNascimento] = useState("");
  const [userData, setUserData] = useState<UserData>();
 
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

  const handleOnClick =  () => {
    setUserData({
      nome: name,
      email,
      cpf,
      dataNascimento,
    });

     makeRequest({ url: "dados", method: "POST", data: userData })
      .then( (response) => [
        console.log(response.data, response.status),
        setStatus(response.status),
      ])
      .catch(() => setStatus(422))
      
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
      {status==201&&<h1 className="return-message">created</h1>}
      {status==422&&<h1 className="return-message">Error</h1>}
    </div>
  );
};

export default DadosBancarios;
