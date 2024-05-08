# API GraphQL com Java: Live Ao Vivo

- Boas vindas ao repositório do código desenvolvido durante nossa sessão ao vivo com a turma de Java! Neste workshop, demonstramos como construir uma API GraphQL usando Java, integrada com um banco de dados PostgreSQL. Este projeto é ideal para estudantes e desenvolvedores iniciantes em GraphQL e Java.   

## O que você encontrará neste repositório?

- Código fonte Completo: Todo o código que foi escrito durante a live, incluindo a integração com o banco de dados PostgreSQL.
- Instruções de Instalação: Um guia passo a passo para configurar e executar a API e o banco de dados localmente.

## Pré-requisitos  


- Para executar este projeto, você precisará ter:
  - Java instalado em sua máquina.
  - Docker para subir o banco de dados PostgreSQL.
  - Uma IDE de sua preferência para desenvolvimento em Java (recomendamos IntelliJ IDEA ou Eclipse).

## DB + Docker

```bash 
docker run --name postgres-live-java -e POSTGRES_PASSWORD=sua_senha -d -p 5432:5432 postgres
```

- Substitua sua_senha por uma senha de sua escolha. Este comando criará um container Docker rodando PostgreSQL, acessível na porta 5432 do seu localhost.
- Utilize um software para se conectar no banco de dados, por exemplo o DBeaver  
- Crie o banco de dados shop  
- Execute o script a baixo: 

```sql 


CREATE TABLE client (
    id    BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NULL,
    name  VARCHAR(255) NULL 
);

CREATE TABLE product (
    id    BIGSERIAL PRIMARY KEY,
    name  VARCHAR(255) NULL, 
    price DOUBLE PRECISION NOT NULL 
);

CREATE TABLE shop (
    id         BIGSERIAL PRIMARY KEY,
    date       TIMESTAMP NULL, 
    quantity   INT NULL,  
    status     VARCHAR(255) NULL,
    client_id  BIGINT NULL,  
    product_id BIGINT NULL,  
    CONSTRAINT fk_shop_product FOREIGN KEY (product_id) REFERENCES product (id), 
    CONSTRAINT fk_shop_client FOREIGN KEY (client_id) REFERENCES client (id)  -- 
);



```

## Como Executar

- Clone o repositório em sua máquina local usando git clone.
- Abra o projeto na IDE escolhida.
- Execute o comando Docker para subir o banco de dados. 
- Acesse o endereço : `localhost:8080/graphiql`   

***Execute o projeto e acesse a interface do GraphQL para começar a fazer suas consultas.
Este projeto é uma ótima oportunidade para entender como APIs GraphQL são construídas e integradas com bancos de dados em Java. Explore o código, adapte-o conforme necessário e contribua com melhorias se desejar. Caso tenha dúvidas ou sugestões, sinta-se à vontade para abrir uma issue ou fazer um pull request!***