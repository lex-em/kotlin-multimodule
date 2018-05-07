package ru.reliabletech.kotlin.multiplatform.web.back.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import ru.reliabletech.kotlin.multiplatform.web.domain.UUID

/**
 * User repository
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface UserRepository: JpaRepository<User, UUID> {

    fun findByLogin(login: String): User?
}