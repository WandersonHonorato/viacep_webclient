package viacep.webclient.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
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
   public Mono<ResponseEntity<ViaCepResponse>> buscar(@PathVariable String cep){
      return viaCepService.buscarCep(cep)
         .map(ResponseEntity::ok);
   }
}
