# Freedom Teste Backend

##  Sobre o projeto

Uma das funcionalidades mais interessantes em um e-commerce
é a Wishlist, ou a lista de desejos. No e-commerce o cliente pode
realizar a busca de produtos, ou pode acessar a tela de detalhes
do produto. Em ambas as telas ele pode selecionar os produtos
de sua preferência e armazená-los na sua Wishlist. A qualquer
momento o cliente pode visualizar sua Wishlist completa, com
todos os produtos que ele selecionou em uma única tela


##  Funcionalidades

- [x] Adicionar um produto na Wishlist do cliente;
- [x] Remover um produto da Wishlist do cliente;
- [x] Consultar todos os produtos da Wishlist do cliente;
- [x] Consultar se um determinado produto está na Wishlist do
      cliente;



### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [Docker](https://docs.docker.com/engine/install/ubuntu/),
- [Docker Compose](https://docs.docker.com/compose/install/),
- [Amazon Corretto 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html).

####  Rodando o Backend (servidor)

```bash

# Iniciar Banco de Dados
$ cd mongodb
$ docker-compose up -d 
# Iniciar Servidor aplicação
$ ./mvnw spring-boot:run

# O servidor inciará na porta:8080 - acesse http://localhost:8080 

```

####  URLS
#####LocalHost
- Banco de Dados http://localhost:8081/
- swagger ui: http://localhost:8080/swagger-ui/index.html
- Api Docs: http://localhost:8080/v2/api-docs
#####Remoto
- swagger ui: https://danilodorgam-wishlist.herokuapp.com/swagger-ui/index.html
- Api Docs: https://danilodorgam-wishlist.herokuapp.com/v2/api-docs
