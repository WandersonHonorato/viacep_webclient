package viacep.webclient.dto;

import lombok.Builder;

@Builder
public record ViaCepResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String UF,
        String DDD
) {
}
