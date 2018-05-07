package ru.reliabletech.kotlin.multiplatform.web.user.controller

import ru.reliabletech.kotlin.multiplatform.web.domain.UUID
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto

/**
 * User operations controller
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface UserController {

    fun getCurrentUser(): UserDto

    fun getUser(id: UUID): UserDto

}