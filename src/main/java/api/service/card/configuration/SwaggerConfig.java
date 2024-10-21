package api.service.card.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiAccounts() {
        return GroupedOpenApi.builder()
                .group("api-cards")
                .pathsToMatch("/api/cards/**")
                .build();
    }
}
