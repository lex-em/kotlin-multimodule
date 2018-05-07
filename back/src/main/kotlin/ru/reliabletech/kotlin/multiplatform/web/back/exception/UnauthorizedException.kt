package ru.reliabletech.kotlin.multiplatform.web.back.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception with 401 error
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException: RuntimeException() {
}