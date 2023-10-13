# BlackJack
Test Code - Alt.Bank

## Projetos
Neste repositório está os projetos de back e frontend.
### Backend - Desenvolvido com Java (JDK 17) - Spring Boot (version: 3.1.4)
blackjack-backend
     blackjack-core
     blackjack-model
     blackjack-rest
### Frontend - Desenvolvido com Angular (Angular: 16.2.6 e Node: 18.14.1)
blackjack-frontend
     

## Para executar o projeto
Necessário a JDK 17 instalada na máquina, quando iniciar a aplicação, o banco é criado e as tabelas são populadas com as informações do arquivo src/main/resources/csv/movielist.csv.
 -  Clone o repositório ou faça download;
 -  Utilizando uma IDE, como por exemplo STS, importe o projeto como Maven;
 -  Para iniciar a aplicação clique no projeto 'blackjack-rest' com o botão direito do mouse, vá até a opção *Run As* e selecione Spring Boot App.

## EndPoints
Acesse: http://localhost:8080/swagger-ui/index.html

## Banco de Dados
http://localhost:8080/h2-console/login.jsp
(clicar em Connect)

## Teste Integração
Para executar o teste abra a classe ProducerControllerIntegrationTest, clique em Run -> Run As -> JUnit Test. 



