package ru.reliabletech.kotlin.multiplatform.web.back.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * Extension for UserDetailsService
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface CommonUserDetailsService : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails

    /**
     * Get user details from security context
     */
    fun getCurrentUserDetails(): UserDetails?
}