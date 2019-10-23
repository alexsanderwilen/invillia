package com.invillia.acme.configuration;


import com.invillia.acme.InvilliaApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerSpringMvcPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(InvilliaApplication.class.getPackage().getName()))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Store API")
                .description("Store API for Invillia")
                .contact(new Contact("José Roberto", "http://localhost:8080", "roberto.jrnj@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/invillia/backend-challenge")
                .version("2.0")
                .build();
    }

}
