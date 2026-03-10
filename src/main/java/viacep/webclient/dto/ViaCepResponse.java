package viacep.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ViaCepResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ddd,
        Boolean erro
) {
}
