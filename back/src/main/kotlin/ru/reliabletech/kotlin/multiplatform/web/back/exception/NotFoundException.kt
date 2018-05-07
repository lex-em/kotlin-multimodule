package ru.reliabletech.kotlin.multiplatform.web.back.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Exception with 404 error
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException: RuntimeException()