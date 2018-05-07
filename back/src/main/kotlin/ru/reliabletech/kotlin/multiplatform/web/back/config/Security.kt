package ru.reliabletech.kotlin.multiplatform.web.back.config

import org.kotlinprimavera.security.config.annnotation.web.builders.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import ru.reliabletech.kotlin.multiplatform.web.back.security.ApplicationUserDetailsService
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.authentication.AuthenticationManager


/**
 * Security configuration
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Configuration
class Security(val userDetailsService: ApplicationUserDetailsService) : WebSecurityConfigurerAdapter() {

    val realm = "multimodule"

    @field:Value("\${springfox.documentation.swagger.v2.path}")
    lateinit var docUrl: String

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/resources/**")
                .antMatchers("/webjars/**")
                .antMatchers("/swagger-ui.html")
    }

    override fun configure(http: HttpSecurity) {
        http
                .httpBasic {
                    realmName(realm)
                }
                .csrf().disable()
                .formLogin {
                    passwordParameter("password")
                    usernameParameter("login")
                    loginProcessingUrl("/login")
                    successHandler { _, response, _ -> response.status = HttpStatus.OK.value() }
                    failureHandler { _, response, _ -> response.status = HttpStatus.UNAUTHORIZED.value() }
                }
                .logout {
                    logoutUrl("/logout")
                    logoutSuccessHandler { _, response, _ -> response.status = HttpStatus.OK.value() }
                    invalidateHttpSession(true)
                    deleteCookies("JSESSIONID")
                }
                .authorizeRequests {
                    antMatchers(docUrl).permitAll()
                    antMatchers("/swagger-resources/**").permitAll()
                    antMatchers("/register").anonymous()
                    antMatchers("/login").anonymous()
                    antMatchers("/logout").authenticated()
                    antMatchers("/**").authenticated()
                }
                .sessionManagement {
                    sessionFixation()
                            .newSession()
                }
//                .rememberMe {
//                    key("remembermekey")
//                            .tokenRepository()
//                }
                .exceptionHandling {
                    accessDeniedHandler { _, response, _ -> response.status = HttpStatus.FORBIDDEN.value() }
                    authenticationEntryPoint { _, response, _ ->
                        response.addHeader("WWW-Authenticate", "Basic realm=\"$realm\"")
                        response.status = HttpStatus.UNAUTHORIZED.value()
                    }
                }
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
    }
//
//    @Bean
//    fun basicAuthFilter(authenticationManager: AuthenticationManager, basicAuthEntryPoint: BasicAuthenticationEntryPoint): BasicAuthenticationFilter {
//        return BasicAuthenticationFilter(authenticationManager, basicAuthEntryPoint())
//    }
//
//    @Bean
//    fun basicAuthEntryPoint(): BasicAuthenticationEntryPoint {
//        val bauth = BasicAuthenticationEntryPoint()
//        bauth.realmName = realm
//        return bauth
//    }

    @Bean
    fun passwordEncoder() = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
