package ru.reliabletech.kotlin.multiplatform.web.back

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackageClasses = [AppConfig::class])
class AppConfig

fun main(vararg args: String) {
    SpringApplication.run(AppConfig::class.java, *args)
}