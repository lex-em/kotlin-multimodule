package ru.reliabletech.kotlin.multiplatform.web.user.dto

/**
 * User registration info DTO
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
data class UserRegistrationDto(val login: String, val password: String, val passwordConfirm: String) {

    fun isPasswordConfirmed() = password == passwordConfirm

}