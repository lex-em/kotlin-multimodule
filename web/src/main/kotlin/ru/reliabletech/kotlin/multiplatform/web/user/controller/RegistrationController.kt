package ru.reliabletech.kotlin.multiplatform.web.user.controller

import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserRegistrationDto

/**
 * Registration controller
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface RegistrationController {

    fun register(registrationData: UserRegistrationDto): Unit
}