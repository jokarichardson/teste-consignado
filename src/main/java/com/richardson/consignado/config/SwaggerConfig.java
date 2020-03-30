package com.richardson.consignado.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    private static final String BASE_PACKAGE = "com.richardson.consignado";
    private static final String TITLE = "Consignado REST Inbound";
    private static final String DESCRIPTION = "Entry port for REST";
    private static final String VERSION = "1.0.0-SNAPSHOT";
    private static final String LICENSE = "Copyright © Richardson Software Ltda - 2020";
    public static final String CONTROLLER_TAG = "Consignado";
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData())
                .tags(new Tag(CONTROLLER_TAG, DESCRIPTION));
    }
    
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .license(LICENSE)
                .build();
    }
    
    @Bean
    UiConfiguration uiConfig() {
      return UiConfigurationBuilder.builder()
          .docExpansion(DocExpansion.LIST)
          .build();
    }
}