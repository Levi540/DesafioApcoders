Instalar Docker

//Apenas Windows - instalar Cygwin
  - Adicionar variável de ambiente
    
    Ex: variáveis do sistema - path: C:\cygwin\bin

//

Instalar IntelliJ IDEA Community Edition

Dentro do IntelliJ abrir arquivo pom.xml na pasta raiz do projeto.

Abrir terminal e executar comando: docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

Dentro do IntelliJ abrir aba "Maven" no canto superior direito e clicar install (desafioapcoders/Lifecycle/install).

Depois executar "Application" em "desafioapcoders/service/src/main/java/br/com/apcoders/desafio/".

Utilizar o Postman ou outro de sua preferência. Server url: localhost:8080/v1


Foi utilizado Spring Boot, Spring Web, Flyway Migration, MySQL Driver, Spring Data JPA, MapStruct, Swagger, Springdoc, OpenAPITools e YAML.

Modelagem do banco de dados:

![desafio apcoders](https://user-images.githubusercontent.com/59920991/150609545-39917bd0-e649-4bec-af7a-afdb6ced1413.png)
