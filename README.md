# Abertura de conta, teste Zup

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/PedroMateus26/abertura-conta-teste-Zup/blob/main/LICENSE) 

# Sobre o projeto

Esse projeto consiste em um cadastro de conta possuindo apenas quatro campos, nome, email, cpf e datas de nascimento. No back-end um crud mais completo foi feito com tratamentos de exceções personalizadas, validação com java beans validation e com annotatioins criadas. 

No front-end apenas os campos para o usuário digitar os dados e um botão salvar. Após clicar no botão uma requisição é enviada ao back-end que retorna a resposta, podendo ser sucesso ou algum tipo de falha definido nas annotations de validação. Essa resposta é exibida ao usuário, em caso de sucesso ou fracasso.

O modelo utilizado foi o padrão em camadas MVC.


# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
## Front end
- HTML / CSS / JS / TypeScript
- ReactJS

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/PedroMateus26/abertura-conta-teste-Zup.git

# entrar na pasta do projeto back end
cd abertura-conta-teste-Zup

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: npm / yarn

```bash

# na pasta do projeto clonado entrar em
cd front-web
cd front-web

# instalar dependências
npm install

# executar o projeto
npm start
```

# Autor

Pedro Mateus Moreira Neto

https://www.linkedin.com/in/pedromateusneto/
