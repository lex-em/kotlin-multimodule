package ru.reliabletech.kotlin.multiplatform.web.exception

/**
 * Error message with code
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
data class Error(val code: Errors, val message: String)