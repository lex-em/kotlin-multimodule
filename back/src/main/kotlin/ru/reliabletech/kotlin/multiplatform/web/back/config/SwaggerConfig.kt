package ru.reliabletech.kotlin.multiplatform.web.back.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.VendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.web.UiConfiguration
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZonedDateTime

/**
 * Swagger configuration
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 *         on 26.04.18.
 */
@EnableSwagger2
@Configuration
class SwaggerConfig {

    @Value("\${documentation.api.version}")
    private val apiVersion: String? = null

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime::class.java, String::class.java)
                .directModelSubstitute(LocalDate::class.java, String::class.java)
                .directModelSubstitute(LocalTime::class.java, String::class.java)
                .directModelSubstitute(ZonedDateTime::class.java, String::class.java)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/")
                .useDefaultResponseMessages(true)
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo("Kotlin multimodule sample",
                "Backend component",
                apiVersion,
                "", Contact("", "", ""),
                "(c) 2018. ReliableTech.ru.",
                "http://blog.reliabletech.ru",
                emptyList<VendorExtension<*>>())
    }

    @Bean
    internal fun uiConfig(): UiConfiguration {
        return UiConfiguration(null) //remove swagger.io validation badge
    }

}
