package com.pes.centro_distribuicao_ms.configs.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API de Centro de Distribuição",
        version = "1.0.0",
        description = "API para os serviços de centro de distribuição de donativos"
))
public class OpenApiConfig {
    // Outras configurações específicas podem ser adicionadas aqui.
}
