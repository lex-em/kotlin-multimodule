package ru.reliabletech.kotlin.multiplatform.web.user.dto

import ru.reliabletech.kotlin.multiplatform.web.domain.UUID

/**
 * User info DTO
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
data class UserDto(var id: UUID? = null, var login: String? = null)