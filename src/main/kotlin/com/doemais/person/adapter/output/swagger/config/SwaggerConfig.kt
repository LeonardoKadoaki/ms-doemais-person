package com.doemais.person.adapter.output.swagger.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfoV1())
            .securityContexts(listOf(securityContext())).securitySchemes(listOf(apiKey()))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.doemais.person")).paths(PathSelectors.any()).build()
            .tags(
                Tag("User", "Manage users"),
            )
    }

    fun apiInfoV1(): ApiInfo? {
        return ApiInfoBuilder().description("PERSON API Rest of Doe+ application").title("Doe+")
            .version("1.0.0")
            //				.version(buildProperties.getVersion())
            .contact(Contact("Doe+", "https://doemais-ifsp.blogspot.com/", "doemais123@gmail.com")).build()
    }

    fun apiKey(): ApiKey? {
        return ApiKey("JWT", "Authorization", "header")
    }

     fun securityContext(): SecurityContext? {
        return SecurityContext.builder().securityReferences(defaultAuth()).build()
    }

    fun defaultAuth(): List<SecurityReference?>? {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes: Array<AuthorizationScope?> = arrayOfNulls(1)
        authorizationScopes[0] = authorizationScope
        return listOf(SecurityReference("JWT", authorizationScopes))
    }
}