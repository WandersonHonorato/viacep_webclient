package viacep.webclient.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

   public Mono<ViaCepResponse> buscar(@PathVariable String cep){
       return viaCepService.buscarCep(cep);
   }
}
