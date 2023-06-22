## Comando para gerar imagem docker da aplicação
- docker build -t cadastro:tag .
- docker build -t app .

## Comando para criar a tag
docker tag app ernilson/devsibreaplataform

## Comando para criar a tag
docker push ernilson/devsibreaplataform

## Comando para criar o Networks
docker network create cadastro-network

## Comando para criar um banco mysql simples
docker run --name containerMySQL -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql

## Comando para acessar o container como root
docker exec -it mysqldb mysql -uroot -p

## Configuração do Application.property
 - spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/testedb
 - spring.datasource.username=${MYSQL_USER:Laravel}
 - spring.datasource.password=${MYSQL_PASSWORD:Laravel}
 - ![A](https://github.com/Ernilson/apiCadastroDocker/assets/30840118/772eaeb9-0347-40eb-b653-a8f98b17eefe)

## Configuração das Variaveis de Ambientes no config do springboot
 - ![springbootapp](https://github.com/Ernilson/apiCadastroDocker/assets/30840118/199c67b0-dee1-4ed6-99a4-c99e125c709c)

## Comando para criar a container do mysql e logo após configurar as variaveis de ambiente na aplicação
docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_DATABASE=testedb -p 3307:3306 -d mysql

## Comando para criar a rede que uni a aplicação ao banco de dados
docker network create cadastro-network

## Comando para listar as networks
docker network ls

## Comando que conectar a rede ao banco de dados (mysqldb)
docker network connect cadastro-network mysqldb

## Comando para inspecionar a rede
docker network inspect cadastro-network

## Comando para expecionar o container
docker container inspect mysqldb

## Comando para criar a container do mysql e logo após configurar as variaveis de ambiente na aplicação
docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_DATABASE=testedb -p 3307:3306 -d mysql

## Comando para criar o containe com a imagem sem a rede de conxao com o banco
docker run -p 9090:8080 --name cadastro -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 cadastro

## Comando para inserir a network para unir a imagem da aplicação ao mysqldb
docker run -p 9090:8080 --name app --net cadastro-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

## Comando para criar o volume
docker run -d -p 3307:3306 --net newnet --name mysqldb -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 -v "/home/ernilson/Desktop/db":/var/lib/mysql mysql

## Comando para chamar o docker-compose up
docker-compose up
docker-compose down

## Esquema
- ![Esquema](https://github.com/Ernilson/apiCadastroDocker/assets/30840118/54127089-d859-4840-8457-b42dc16c9979)

