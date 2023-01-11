# MUDI
Aplicação para solicitação e envio de produtos importados.


# Tecnologias usadas

Foram usadas as seguintes tecnologias ao desenvolver esse projeto:

- Java 11
- Maven
- JPA
- Spring Data JPA
- Spring MVC
- Thymeleaf
- AJAX com Axios
- Vue.js
- Bootstrap
- BeanValidation
- Regex
- MariaDB
- Spring Security
- Apache Tomcat
- HTML5


# Getting Started

### Você pode: 

- Baixar o [ZIP do projeto](https://github.com/matthewmatheus/mudi/archive/refs/heads/master.zip) e abri-lo em uma IDE de sua preferência.

### Ou

- Clonar o repositório `https://github.com/matthewmatheus/mudi`


- Rodar `mvn clean install` para instalar as dependências do projeto.

- Rodar `mvn spring-boot:run` para subir a aplicação.

- A aplicação estará disponível na port `8080`. <br> <br>
( Para alterar a porta modifique o `server.port` no arquivo `application.properties` ).

<br> 

# Login
### Qualquer requisição na aplicação só poderá ser feita por um usuário autenticado.

A aplicação terá por padrão:
- username: maria 
- password: maria



Após o login você poderá fazer logout a hora que quiser, e caso queira alterar o usuário padrão é só mudar o código em `WebSecurityConfiguration`.

![image](https://user-images.githubusercontent.com/101140467/211859512-c3e84ac7-05e4-49da-aa16-3060cc5443c7.png)



<br>

O usuário pode cadastrar um novo produto em `Meus pedidos` > `Novo`, basta preencher o formulário corretamente.

Em `Meus Pedidos` também é possível ver todos os pedidos de acordo com seu status atual 

<br>

![m1](https://user-images.githubusercontent.com/101140467/211859147-605f9865-b8e6-423c-8252-ceee0f0eef21.jpg)

<br>

Em `Faça sua ofeta` é possível fazer uma oferta num pedido postado por outro cliente, informando o valor que você cobra, a data da entrega e um comentário.

![image](https://user-images.githubusercontent.com/101140467/211860445-553ac77c-827c-4102-9043-1e356876631e.png)







