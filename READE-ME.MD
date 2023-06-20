## Comando para gerar imagem docker da aplicação
- docker build -t cadastro:tag .
- docker build -t app .

## Comando para criar o Networks
docker network create cadastro-network

## Comando para acessar o container como root
docker exec -it mysqldb mysql -uroot -p

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

//--> Comando para criar a container do mysql e logo após configurar as variaveis de ambiente na aplicação
docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_DATABASE=testedb -p 3307:3306 -d mysql

## Comando para criar o containe com a imagem sem a rede de conxao com o banco
docker run -p 9090:8080 --name cadastro -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 cadastro

## Comando para inserir a network para unir a imagem da aplicação ao mysqldb
docker run -p 9090:8080 --name app --net cadastro-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 app

/--> para criar o volume
docker run -d -p 3307:3306 --net newnet --name mysqldb -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 -v "/home/ernilson/Desktop/db":/var/lib/mysql mysql

## Comando para chamar o docker-compose up
docker-compose up
docker-compose down

