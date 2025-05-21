# Loja de Jogos API

API de uma loja de jogos online, desenvolvida como parte do Projeto Final do Bloco 02. 
Este projeto consiste em uma API RESTful para gerenciar produtos e categorias de uma loja de jogos.

## Configuração e Execução

### Pré-requisitos

- Java 17
- Maven

### Build do Projeto

Para construir o projeto, execute o seguinte comando na raiz do projeto:

```bash
mvn clean install
```

### Execução do Projeto

Para executar a aplicação, você pode utilizar o plugin do Spring Boot com o Maven:

```bash
mvn spring-boot:run
```

Alternativamente, você pode executar a classe principal `ProjetoFinalBloco02Application.java` diretamente da sua IDE.

A API estará disponível em `http://localhost:8080`.

## Endpoints da API

A API expõe os seguintes endpoints para gerenciamento de categorias e produtos:

### Categorias

- `GET /categorias`: Lista todas as categorias.
- `GET /categorias/{id}`: Busca uma categoria específica pelo seu ID.
- `GET /categorias/categoria/{categoria}`: Busca categorias pelo nome (busca parcial, case-insensitive).
- `POST /categorias`: Cria uma nova categoria.
  - Corpo da requisição: Objeto JSON representando a categoria.
- `PUT /categorias`: Atualiza uma categoria existente.
  - Corpo da requisição: Objeto JSON representando a categoria com seu ID.
- `DELETE /categorias/{id}`: Deleta uma categoria pelo seu ID.

### Produtos

- `GET /produtos`: Lista todos os produtos.
- `GET /produtos/{id}`: Busca um produto específico pelo seu ID.
- `GET /produtos/produtos/{nomeProduto}`: Busca produtos pelo nome (busca parcial, case-insensitive).
- `POST /produtos`: Cria um novo produto.
  - Corpo da requisição: Objeto JSON representando o produto, incluindo o ID de uma categoria existente.
- `PUT /produtos`: Atualiza um produto existente.
  - Corpo da requisição: Objeto JSON representando o produto com seu ID, incluindo o ID de uma categoria existente.
- `DELETE /produtos/{id}`: Deleta um produto pelo seu ID.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Data JPA
- Maven
- MySQL (como banco de dados)
- Spring Boot DevTools
- Spring Boot Actuator

## Contribuições

Contribuições são bem-vindas! Se você tiver sugestões, correções de bugs ou novas funcionalidades, sinta-se à vontade para abrir uma issue ou enviar um pull request.

Para contribuir:

1. Faça um fork do projeto.
2. Crie uma nova branch (`git checkout -b feature/sua-feature`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/sua-feature`).
5. Abra um Pull Request.
