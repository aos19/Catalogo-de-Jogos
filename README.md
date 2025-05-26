# Catálogo de Games com Spring

[![Java](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![JPA](https://img.shields.io/badge/JPA-Specification-blue.svg)](https://jakarta.ee/specifications/persistence/)
[![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)](https://maven.apache.org/)
[![H2 Database](https://img.shields.io/badge/H2%20Database-In--Memory-lightgrey.svg)](https://www.h2database.com/html/main.html)
[![Build Status](https://img.shields.io/badge/Build-Passing-success.svg)](#) [![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE) ## 🎮 Sobre o Projeto

Construção de um catálogo de games utilizando o framework Spring com Java. O objetivo é fornecer uma API RESTful que permita aos usuários visualizar informações sobre alguns jogos, organizados em listas. Este projeto serve como um estudo prático da utilização do Spring Boot para desenvolvimento de back-end, explorando conceitos como JPA para persistência de dados e REST para comunicação.

## ✨ Características 

* **Listagem de Games:** Permite visualizar todos os games cadastrados no catálogo.
* **Listagem de Games por Lista:** Permite visualizar os games pertencentes a uma lista específica.
* **Detalhes do Game:** Permite visualizar informações detalhadas sobre um game específico.
* **API RESTful:** Comunicação através de endpoints REST utilizando o protocolo HTTP.
* **Persistência de Dados:** Utilização do JPA (Java Persistence API) com Hibernate para interagir com o banco de dados.
* **Banco de Dados embutido H2:** Configurado para facilitar o desenvolvimento e testes.
* **Containerização com Docker:** Facilidade de execução e portabilidade através do Docker.

## 🛠️ Stack do Projeto

* **Linguagem de Programação:** Java (versão 21)
* **Framework Back-end:** Spring Boot (versão 3.2.7)
* **Persistência de Dados:** JPA (Java Persistence API)
* **ORM (Object-Relational Mapping):** Hibernate
* **Banco de Dados:** H2 Database (em memória, para desenvolvimento)
* **Gerenciamento de Dependências:** Maven
* **Testes:** Spring Boot Starter Test (JUnit, Mockito)
* **API REST:** Spring Web

## 🚀 Como Executar o Projeto

Siga estas instruções para executar o projeto no seu ambiente local.

### Pré-requisitos

* **Java Development Kit (JDK):** Versão 17 ou superior instalada. Você pode baixar em [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/).
* **Maven:** Versão 3.x instalada. Você pode verificar a instalação com `mvn -v`. Instruções de instalação em [Apache Maven](https://maven.apache.org/download.cgi).
* **Docker Desktop:** Instalado e em execução (se você pretende usar a containerização). Você pode baixar em [Docker Desktop](https://www.docker.com/products/docker-desktop/).
* **Postman ou Insomnia:** (Opcional) Para testar os endpoints da API REST.

### Execução Local (Sem Docker)

1.  **Clone o repositório:**
    ```bash
    git clone [https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content](https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content)
    cd [nome do seu repositório]
    ```

2.  **Execute a aplicação Spring Boot usando Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
    Ou, se você não estiver usando o Maven Wrapper:
    ```bash
    mvn spring-boot:run
    ```

3.  **A aplicação estará disponível em:** `http://localhost:8080` (a porta padrão do Spring Boot).

### Execução com Docker

1.  **Clone o repositório:**
    ```bash
    git clone [https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content](https://docs.github.com/en/repositories/archiving-a-github-repository/referencing-and-citing-content)
    cd [nome do seu repositório]
    ```

2.  **Construa a imagem Docker:**
    ```bash
    docker build -t catalogo-games .
    ```

3.  **Execute o container Docker:**
    ```bash
    docker run -p 8080:8080 catalogo-games
    ```
    Ou, utilizando o Docker Compose (se você tiver um arquivo `docker-compose.yml`):
    ```bash
    docker-compose up -d
    ```

4.  **A aplicação estará disponível em:** `http://localhost:8080`.

## Endpoints da API REST

Aqui estão os endpoints da API REST atualmente implementados:

* **`GET /games`**: Retorna uma lista de todos os games (em formato `GameMinDTO`).
* **`GET /{listId}/games`**: Retorna uma lista dos games pertencentes à lista com o ID especificado (em formato `GameMinDTO`).
