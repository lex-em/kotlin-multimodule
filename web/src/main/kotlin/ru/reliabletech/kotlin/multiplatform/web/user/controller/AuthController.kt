package ru.reliabletech.kotlin.multiplatform.web.user.controller

/**
 * Authentication controller
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
interface AuthController {

    fun login(login: String, password: String): Unit

    fun logout(): Unit

}