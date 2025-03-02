package kr.co.joneconsulting.myrestfulservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "My Restful Service API ����",
                description = "Spring Boot�� �����ϴ� RESTful API �����Դϴ�.",
                version = "v2.0.0"))
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenApi () {
        String[] paths = {"/users/**", "/admin/**"};

        return GroupedOpenApi
                .builder()
                .group("�Ϲ� ����ڿ� �����ڸ� ���� User �����ο� ���� API")
                .pathsToMatch(paths).build();
    }
}
