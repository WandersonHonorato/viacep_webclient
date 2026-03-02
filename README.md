<h1 align="center">📦 ViaCEP WebClient API</h1>

<p align="center">
API REST desenvolvida com Spring Boot + Spring WebFlux + WebClient para consumo da API externa do ViaCEP.
</p>

<p align="center">
<img src="https://img.shields.io/badge/Java-21-red">
<img src="https://img.shields.io/badge/Spring_Boot-3.x-brightgreen">
<img src="https://img.shields.io/badge/Apache-Maven-purple">
<img src="https://img.shields.io/badge/WebFlux-Reactive-blue">
<img src="https://img.shields.io/badge/Junit-5-green">
<img src="https://img.shields.io/badge/Swagger-OpenAPI 3-brightgreen">
<img src="https://img.shields.io/badge/Web-Client-orange">
</p>

---

<h2>Descrição</h2>
Projeto focado em prática de arquitetura em camadas, programação reativa e boas práticas de tratamento de exceções.

## <h2>📌 Objetivo do Projeto</h2>

Esta aplicação permite consultar endereços a partir de um CEP, consumindo a API externa do ViaCEP de forma não bloqueante, utilizando Spring WebFlux.

O objetivo principal foi praticar:<br>

Programação reativa com Mono<br>
Consumo de API externa com WebClient<br>
Arquitetura organizada em camadas<br>
Tratamento global de exceções<br>
Documentação com Swagger (OpenAPI)

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
⚙️ Como Executar
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
