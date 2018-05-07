package ru.reliabletech.kotlin.multiplatform.web.back.user.service

import ru.reliabletech.kotlin.multiplatform.web.domain.UUID
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserRegistrationDto

/**
 * User service
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface UserService {

    /**
     * Get user by id
     */
    fun getUser(id: UUID): UserDto

    /**
     * Get current authenticated user
     */
    fun getCurrentUser(): UserDto

    /**
     * User registration action
     */
    fun registerUser(registrationDto: UserRegistrationDto): Unit
}