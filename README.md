<h1 align="center">📦 ViaCEP WebClient API</h1>

<p align="center">
API REST desenvolvida com <strong>Spring Boot</strong> +  <strong>Spring WebFlux</strong> +  <strong>WebClient</strong> para consumo da API externa do ViaCEP.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot">
  <img src="https://img.shields.io/badge/WebFlux-Reactive-blue?style=for-the-badge">
  <img src="https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven">
  <img src="https://img.shields.io/badge/junit-5-green?style=for-the-badge&logo=Junit5">
  <img src="https://img.shields.io/badge/Swagger-OpenAPI 3-green?style=for-the-badge&logo=swagger">
  <img src="https://img.shields.io/badge/Spring-WebClient-white?style=for-the-badge&logo=webclient">
</p>

---

<p align="center">
<strong>Navegação</strong>
</p>

<p align="center">
  • <a href="#-descrição">📋Descrição</a> •
  <a href="#-objetivo-do-projeto">📌Objetivo do Projeto</a> •
  <a href="#-tecnologias-utilizadas">⚙️Tecnologias Utilizadas</a>
  <br>
  • <a href="#-arquitetura-do-projeto">📁Arquitetura do Projeto</a> •
  <a href="#-conceitos-aplicados">🧠Conceitos Aplicados</a> •
  <a href="#-como-executar">▶️Como Executar</a> •
  <a href="http://localhost:8080/swagger-ui.html">📘 Swagger</a>
</p>

<br>



<h2>📋 Descrição</h2>
Projeto focado em prática de arquitetura em camadas, programação reativa e boas práticas de tratamento de exceções.
Esta aplicação permite consultar endereços a partir de um CEP, consumindo a API externa do ViaCEP de forma não bloqueante, utilizando Spring WebFlux.

<h2>📌 Objetivo do Projeto</h2>

O objetivo principal foi praticar:<br>

Programação reativa com Mono<br>
Consumo de API externa com WebClient<br>
Arquitetura organizada em camadas<br>
Tratamento global de exceções<br>
Documentação com Swagger (OpenAPI)

<h2>🚀 Tecnologias Utilizadas</h2>

☕ Java 21+<br>
🌱 Spring Boot 3.x<br>
🌐 Spring WebFlux<br>
🔗 WebClient<br>
🛠 Maven<br>
📦 Lombok<br>


## <h2>📁 Arquitetura do Projeto</h2>

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

## <h2>🧠 Conceitos Aplicados</h2>


Mono<T><br>
map()<br>
Tratamento de exceções com @ExceptionHandler<br>
Arquitetura em camadas (Controller → Service → Client)<br>

## <h2>🔍 Endpoint Disponível</h2>


📌 Buscar CEP<br>
<br>
````GET /api/cep/{cep}```` <br>
<br>
📥 Exemplo de Requisição <br>
<br>
````curl http://localhost:8080/api/cep/01001000````<br>
<br>
📤 Exemplo de Resposta <br>
````
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ddd": "11"
}
````
🧩 Exemplo do Controller
````@GetMapping("/{cep}")
public Mono<ResponseEntity<ViaCepResponse>> buscarCep(@PathVariable String cep) {
    return viaCepService.buscarCep(cep)
            .map(ResponseEntity::ok);
}
````
<h2>▶️ Como Executar<h2>
  
1️⃣ Clonar o repositório

git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git

2️⃣ Rodar a aplicação
mvn spring-boot:run

A aplicação estará disponível em:

http://localhost:8080
🛡 Tratamento Global de Erros

Exemplo de resposta para CEP inválido:

{
  "timestamp": "2026-02-26T14:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "CEP inválido"
}
📊 Conceitos Demonstrados

✔ Programação Reativa com Mono
✔ Consumo de API externa com WebClient
✔ Tratamento global de exceções
✔ Boas práticas REST
✔ Clean Code

👨‍💻 Autor

Wanderson Honorato
🔗 LinkedIn: https://www.linkedin.com/in/wanderson-honorato/
