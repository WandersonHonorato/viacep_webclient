<h1> ViaCEP WebClient API </h1>

API reativa desenvolvida com pring Boot + WebFlux + WebClient para consumo da API pública do ViaCEP.

<h3>📋 Descrição</h3>
Projeto focado em prática de arquitetura em camadas, programação reativa e boas práticas de tratamento de exceções.

##
<h2>🚀 Tecnologias Utilizadas</h2>

Java 17+
Spring Boot
Spring WebFlux
WebClient
Maven
Junit5 (testes)
Swagger (OpenAPI 3)
Lombok

##
<h2>📌 Objetivo do Projeto</h2>

Esta aplicação permite consultar endereços a partir de um CEP, consumindo a API externa do ViaCEP de forma não bloqueante, utilizando Spring WebFlux.

O objetivo principal foi praticar:<br>

Programação reativa com Mono<br>
Consumo de API externa com WebClient<br>
Arquitetura organizada em camadas<br>
Tratamento global de exceções<br>
Documentação com Swagger (OpenAPI)
##

🧠 Conceitos Aplicados

Mono<T>
map()
Tratamento de exceções com @ExceptionHandler
Arquitetura em camadas (Controller → Service → Client)
