<h1>📦 API de Consulta de CEP - ViaCEP</h1>

API reativa desenvolvida com pring Boot + WebFlux + WebClient para consumo da API pública do ViaCEP.

<h3>Descrição</h3>
Projeto focado em prática de arquitetura em camadas, programação reativa e boas práticas de tratamento de exceções.

##
<h2>🚀 Tecnologias Utilizadas</h2>
☕ Java 21<br>
🌱 Spring Boot<br>
🌐 Spring WebFlux<br>
🔗 WebClient<br>
🛠 Maven<br>
Junit5 (testes)<br>
Swagger (OpenAPI 3)<br>
Lombok<br>

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

<h2>🏗️ Arquitetura do Projeto</h2>

O projeto segue uma estrutura em camadas:

Controller → Service → Client (WebClient) → API Externa

```bash
src/
├── main/
│   ├── java/com/viacep/webclient/
│   │   ├── controller/           # Controllers REST
│   │   ├── service/              # Serviços de negócio
│   │   ├── client/               # Entidades JPA
│   │   ├── dto/                  # Data Transfer Objects
│   │   ├── config/               # Configurações
│   │   ├── exception/            # Tratamento de exceções
│   │              
│   └── resources/
│       ├── application.properties
└── test/                        # Testes unitários
```


🧠 Conceitos Aplicados

Mono<T>
map()
Tratamento de exceções com @ExceptionHandler
Arquitetura em camadas (Controller → Service → Client)
