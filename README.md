# 🧩 Campeonatos GraphQL

Este projeto é uma API construída com **Spring Boot**, **GraphQL** e **MongoDB**, estruturada seguindo os princípios da **Arquitetura Hexagonal** (Ports & Adapters).  
O objetivo é fornecer uma base limpa e escalável para manipulação de campeonatos e times em um contexto de jogos ou esportes eletrônicos.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring GraphQL**
- **MongoDB**
- **Docker**
- **Arquitetura Hexagonal (Ports & Adapters)**

---

## ⚙️ Como Executar o Projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-usuario/campeonatos-graphql.git
cd campeonatos-graphql

docker run -d --name mongodb -p 27017:27017 mongo

./mvnw spring-boot:run

mvn spring-boot:run

http://localhost:8080


Cria um novo campeonato:

mutation {
  criarCampeonato(input: { nome: "Campeonato Brasileiro" }) {
    id
    nome
  }
}

Lista todos os campeonatos cadastrados:

query {
  campeonatos {
    id
    nome
  }
}

🧩 Verificando os Dados no MongoDB

Se quiser consultar os registros diretamente no banco:

docker exec -it mongodb mongosh
use campeonatos
db.campeonatos.find().pretty()