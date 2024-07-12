# API Rest da empresa fictícia Agi.med

Este projeto é uma API Rest desenvolvida em Java utilizando o Spring Boot. A API tem como objetivo gerenciar os dados de pacientes e medicos da empresa fictícia Agi.med. 

## Funcionalidades

- Cadastro de pacientes e medicos
- Consulta de pacientes e medicos
- Atualização de dados de pacientes e medicos
- Exclusão de pacientes e medicos

## Dependências

Este projeto utiliza as seguintes dependências:

- **Spring Boot Starter Web**: Para criação de endpoints RESTful.
- **Spring Boot DevTools**: Para facilitar o desenvolvimento com ferramentas de live reload.
- **Lombok**: Para reduzir o boilerplate de código, como getters, setters e construtores.
- **Spring Boot Starter Data JPA**: Para integração com o banco de dados utilizando JPA/Hibernate.
- **Spring Boot Starter Validation**: Para validação de dados de entrada.
- **Flyway Core**: Para migrações de banco de dados.
- **Flyway MySQL**: Para suporte específico a MySQL nas migrações de banco de dados.
- **MySQL Connector/J**: Driver JDBC para conexão com o banco de dados MySQL.
- **Spring Boot Starter Test**: Para testes unitários e de integração.

## Requisitos

- Java 17
- Maven 3.6+
- MySQL

## Configuração do Banco de Dados

Certifique-se de configurar o banco de dados MySQL no arquivo `application.properties` ou `application.yml` da seguinte forma:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## Migrações de Banco de Dados

O projeto utiliza o Flyway para gerenciar as migrações do banco de dados. As migrações estão localizadas na pasta `src/main/resources/db/migration`.

## Executando a Aplicação

Para executar a aplicação, utilize o seguinte comando Maven:

```bash
mvn spring-boot:run
```

## Estrutura do Projeto

- `src/main/java`: Contém o código fonte da aplicação.
- `src/main/resources`: Contém os arquivos de configuração e scripts de migração do banco de dados.
- `src/test`: Contém os testes unitários e de integração.

## Endpoints

Abaixo estão os principais endpoints da API:

### Criar Paciente

- **URL**: `/api/pacientes`
- **Método**: `POST`
- **Corpo da Requisição**:
  ```json
  {
      "nome": "João da Silva",
      "email": "joao.silva@example.com",
      "cpf": "12345678900",
      "telefone": "11987654321",
      "logradouro": "Rua das Flores",
      "bairro": "Jardim das Acácias",
      "cep": "12345678",
      "complemento": "Apto 101",
      "numero": "123",
      "uf": "SP",
      "cidade": "São Paulo"
  }
  ```

### Consultar Pacientes

- **URL**: `/api/pacientes`
- **Método**: `GET`

### Consultar Paciente por ID

- **URL**: `/api/pacientes/{id}`
- **Método**: `GET`

### Atualizar Paciente

- **URL**: `/api/pacientes/{id}`
- **Método**: `PUT`
- **Corpo da Requisição**:
  ```json
  {
      "nome": "João da Silva",
      "email": "joao.silva@example.com",
      "cpf": "12345678900",
      "telefone": "11987654321",
      "logradouro": "Rua das Flores",
      "bairro": "Jardim das Acácias",
      "cep": "12345678",
      "complemento": "Apto 101",
      "numero": "123",
      "uf": "SP",
      "cidade": "São Paulo"
  }
  ```

### Excluir Paciente

- **URL**: `/api/pacientes/{id}`
- **Método**: `DELETE`

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## Desenvolvedores

- Marcus Ungarette

## Contato

Para mais informações, entre em contato com [marcusungarette@gmail.com](mailto:marcusungarette@gmail.com).

---

Este README fornece uma visão geral do projeto, suas dependências, configuração e como utilizá-lo. Sinta-se à vontade para ajustá-lo conforme necessário para atender às especificidades do seu projeto.
