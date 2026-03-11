package viacep.webclient.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import viacep.webclient.dto.ViaCepResponse;
import viacep.webclient.service.ViaCepService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cep")
public class CepController {

   private final ViaCepService viaCepService;

   @GetMapping("/{cep}")
   @Operation(summary = "Buscar endereço por CEP",
           description = "Consulta um endereço utilizando a API ViaCEP")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "CEP encontrado"),
           @ApiResponse(responseCode = "404", description = "CEP não encontrado"),
           @ApiResponse(responseCode = "400", description = "CEP inválido")
   })
   @Parameter(description = "CEP para busca", example = "60165121")
   // Mono (0 ou 1); Flux (1 ou N)
   public Mono<ViaCepResponse> buscar(@PathVariable String cep){
       return viaCepService.buscarCep(cep);
   }
}
