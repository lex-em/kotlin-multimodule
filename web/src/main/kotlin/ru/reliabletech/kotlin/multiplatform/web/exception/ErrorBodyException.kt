package ru.reliabletech.kotlin.multiplatform.web.exception

/**
 * Exception with error
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
abstract class ErrorBodyException(val error: Error) : RuntimeException()