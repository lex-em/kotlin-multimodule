package ru.reliabletech.kotlin.multiplatform.web.back.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import ru.reliabletech.kotlin.multiplatform.web.exception.Error
import ru.reliabletech.kotlin.multiplatform.web.exception.ErrorBodyException

/**
 * Common exception handler
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ErrorBodyException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handle(exception: ErrorBodyException) : Error = exception.error
}