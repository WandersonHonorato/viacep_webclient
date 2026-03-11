package viacep.webclient.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI customeAPI() {
        return new OpenAPI()
          .info(new Info()
                  .title("API Consulta CEP")
                  .version("1.0")
                  .description("API para consulta de CEP utilizando o serviço ViaCEP"));
    }
}
