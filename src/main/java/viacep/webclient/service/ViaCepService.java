package viacep.webclient.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import viacep.webclient.dto.ViaCepResponse;

@RequiredArgsConstructor
@Service
public class ViaCepService {

    private final WebClient webclient;

    public Mono<ViaCepResponse> buscarCep(String cep) {

        cep = cep.replace("-", "");

        if (cep.length() < 8) {
            throw new IllegalArgumentException("CEP inválido");
        }

        return webclient
                .get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .bodyToMono(ViaCepResponse.class);
    }
}
