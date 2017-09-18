package com.ymedaghri.retrogames.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by medaghrialaouiyoussef on 18/09/2017.
 */
@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@Configuration
public class SwaggerConfiguration {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENSE_TEXT = "Apache License Version 2.0";
    public static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    private static final String TITLE = "Retrogames REST API";
    private static final String DESCRIPTION = "RESTful API for Retrogames Application";
    public static final String GROUP_NAME = "public-api";
    public static final String TERMS_OF_SERVICE_URL = "http://swagger.io/terms/";


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .license(LICENSE_TEXT)
                .licenseUrl(LICENSE_URL)
                .termsOfServiceUrl(TERMS_OF_SERVICE_URL)
                .contact(new Contact("Youssef Medaghri-Alaoui", "https://ymedaghri.github.io/", "ymedaghri@gmail.com"))
                .version(SWAGGER_API_VERSION)
                .build();
    }

    @Bean
    public Docket retrogamesApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.or(regex("/api.*"), regex("/token")))
                .build()
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    @Bean SecurityConfiguration security() {
        return new SecurityConfiguration(
                null,
                null,
                null,
                null,
                "",
                ApiKeyVehicle.HEADER,
                "Authorization",
                ","); }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api.*"))
                .build();
    }



    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }

}
