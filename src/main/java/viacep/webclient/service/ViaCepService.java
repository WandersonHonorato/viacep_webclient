package viacep.webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import viacep.webclient.dto.ViaCepResponse;
import viacep.webclient.exception.CepNotFoundException;

@RequiredArgsConstructor
@Service
public class ViaCepService {

    private final WebClient webclient;

    public Mono<ViaCepResponse> buscarCep(String cep) {

       String cepFormatado = cep.replace("-", "");

        if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("CEP deve conter 8 números.");
        }

        return webclient
                .get()
                .uri("/{cep}/json/", cepFormatado)
                .retrieve()
                .bodyToMono(ViaCepResponse.class)
                .flatMap(response -> {
                    if (Boolean.TRUE.equals(response.erro())) {
                        return Mono.error(
                                new CepNotFoundException(cepFormatado));
                    }
                    return Mono.just(response);
                });
    }
}