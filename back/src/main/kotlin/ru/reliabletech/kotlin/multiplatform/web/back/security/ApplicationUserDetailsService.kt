package ru.reliabletech.kotlin.multiplatform.web.back.security

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import ru.reliabletech.kotlin.multiplatform.web.back.user.domain.UserRepository

/**
 * Realization for project extension of UserDetailService
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Component
class ApplicationUserDetailsService(val userRepository: UserRepository) : CommonUserDetailsService {

    override fun getCurrentUserDetails(): UserDetails?
            = SecurityContextHolder.getContext().authentication?.principal as UserDetails

    override fun loadUserByUsername(username: String): UserDetails
            = userRepository.findByLogin(username)
                ?.let {
                    User(username, it.password, listOf(SimpleGrantedAuthority("USER")))
                }
                ?: throw UsernameNotFoundException("User not found")

}