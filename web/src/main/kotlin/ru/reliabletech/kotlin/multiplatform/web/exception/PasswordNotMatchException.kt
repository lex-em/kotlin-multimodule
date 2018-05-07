package ru.reliabletech.kotlin.multiplatform.web.exception

/**
 * Exception with password do not match exception
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
class PasswordNotMatchException(message: String = "") : ErrorBodyException(Error(Errors.PASSWORD_NOT_MATCH, message))