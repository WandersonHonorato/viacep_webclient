## <h1 align="center">ViaCEP WebClient API</h1>

<p align="center">
API REST desenvolvida com <strong>Spring Boot</strong> + <strong>Spring WebFlux</strong> + <strong>WebClient</strong> para consumo da API externa do ViaCEP.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot">
  <img src="https://img.shields.io/badge/Spring-WebFlux-blue.svg?style=for-the-badge&logo=spring&logoColor=white">
   <br>
  <img src="https://img.shields.io/badge/Spring-WebClient-white?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven">
    <img src="https://img.shields.io/badge/Git-white?style=for-the-badge&logo=git">
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate">
  <img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
  </p>

---

<p align="center">
<strong>Navegação</strong>
</p>

<p align="center">
  • <a href="#-descrição">📋 Descrição</a> •
  <a href="#-objetivo-do-projeto">📌Objetivo do Projeto</a> •
  <a href="#-arquitetura-do-projeto">📁Arquitetura do Projeto</a>
  • <a href="#-tecnologias-utilizadas">⚙️ Tecnologias Utilizadas</a>
    <br>
  • <a href="#-conceitos-aplicados">🧠 Conceitos Aplicados</a> •
  <a href="#-pre-requisitos">🛠️ Pré-requisitos</a>
  • <a href="#-como-executar">▶️ Como Executar</a>
  • <a href="#tratamentos-de-exceções">❎ Tratamentos de Exceções</a>
  • <a href="#-swagger-openApi">❎ Swagger OpenApi</a>



</p>

<br>

<h2>📋 Descrição</h2>
Projeto focado em prática de arquitetura em camadas, programação reativa e boas práticas de tratamento de exceções.
Esta aplicação permite consultar endereços a partir de um CEP, consumindo a API externa do ViaCEP de forma não bloqueante, utilizando Spring WebFlux.

<h2>📌 Objetivo do Projeto</h2>

O objetivo principal foi praticar:<br>

- ✅ Programação reativa com Mono<br>
- ✅ Consumo de API externa com WebClient<br>
- ✅ Arquitetura organizada em camadas<br>
- ✅ Tratamento global de exceções<br>
- ✅ Documentação com Swagger (OpenAPI)

<h2>📁 Arquitetura do Projeto</h2>

O projeto segue uma estrutura em camadas:

Controller → Service → Client (WebClient) → API Externa

```bash
src/
├── main/
│   ├── java/com/viacep/webclient/
|   |   ├── config/               # OpenAPI configurações (Swagger)
|   |       ├── OpenApiConfig     
│   │   ├── controller/           # Controllers REST
|   |       ├── CepController      
│   │   ├── dto/                  # Data Transfer Objects
|   |       ├── ViaCEpResponse                  
│   │   ├── exception/            # Tratamento global de exceções
|   |       ├── CepNotFoundException           
|   |   ├── handler/              # Exceção customizada
|   |       ├── GlobalExceptionHandler       
|   |   ├── response/             # Retorno da API
|   |       ├── ErrorResponse          
│   │   ├── service/              # Serviços de negócio
|   |       ├── ViaCeoService        
│   │   ├── clientClientConfig/   # Configurações WebClient
|   |       ├── webClientConfig                      
│   └── resources/
│       ├── application.properties
└── test/                     
```

<h2>⚙️ Tecnologias Utilizadas</h2>

<strong>Backend</strong>
- Java 21<br>
- Spring Boot 3.x<br>
- Spring WebFlux<br>
- WebClient<br>
- Lombok<br>

<strong>Outors</strong>
- Maven<br>
- Swagger/OpenAPI

<h2>🧠 Conceitos Aplicados</h2>

Spring WebFlux
Programação Reativa com Mono<T> (0 ou 1) e Flux (1 o N)<br>
Retornos Http<br>
Consumir API externa<br>
Tratamento de exceções customizadas com @RestControllerAdvice<br>
Arquitetura de camadas (Controller → Service → Client)

<h2 id="pre-requisitos">🛠️ Pré-requisitos</h2>

Antes de começar, você precisará ter as seguintes ferramentas instaladas:

- <a href="https://www.oracle.com/br/java/technologies/downloads/">Java 21</a><br>
- <a href="https://spring.io/blog/2009/12/04/logging-dependencies-in-spring">Spring Boot 3+</a><br>
- <a href="https://spring.io/blog/2009/12/04/logging-dependencies-in-spring">WebFlux</a><br>
- <a href="https://spring.io/blog/2009/12/04/logging-dependencies-in-spring">SpringWeb</a><br>
- <a href="https://spring.io/blog/2009/12/04/logging-dependencies-in-spring">Lombok</a><br>


<h2 id="como-executar">▶️ Como Executar</h2>
  
1. **Clone o repositório**
````bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git
````
2. **Rodar a aplicação**

3. Usando Maven Wrapper (recomendado)
```bash
./mvnw spring-boot:run
````
4. **Ou usando Maven instalado**
````bash
mvn spring-boot:run
````

<h2>📌 Buscar CEP</h2>
 
```
GET/cep/{cep}
````
- Exemplo de Requisição <br>


````
curl http://localhost:8080/cep/01001000
````

- Exemplo de Resposta (200) <br>

````
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ddd": "11"
  "error": null
}
````
### 🧩 Exemplo do Controller
````@GetMapping("/{cep}")
   public Mono<ViaCepResponse> buscar(@PathVariable String cep){
       return viaCepService.buscarCep(cep);
}
````


<h2 id="swagger-openapi">❎ Swagger OpenApi</h2>

````Acessar documentação da API na porta 8080:
http://localhost:8080/swagger-ui.html
````
ou tentar pelo link:
````
http://localhost:8080/swagger-ui/index.html
````

<h2 id="tratamento-de-erros">⚠️ Tratamento de Exceções:</h2>

Exemplo de resposta para CEP inválido (400):

````
{
  "timestamp": "13-03-2026 08:55:37",
  "status": 400,
  "error": "Bad Request",
  "message": "CEP deve conter 8 números.",
  "path": "/cep/abc"
}
````
Exemplo de resposta para CEP não encontrado (404):

````
{
  "timestamp": "13-03-2026 08:56:31",
  "status": 404,
  "error": "Not Found",
  "message": "CEP não encontrado: 11111111",
  "path": "/cep/11111111"
}
````

### 👨‍💻 Autor

Wanderson Honorato:<BR>
🔗 LinkedIn: https://www.linkedin.com/in/wanderson-honorato/
