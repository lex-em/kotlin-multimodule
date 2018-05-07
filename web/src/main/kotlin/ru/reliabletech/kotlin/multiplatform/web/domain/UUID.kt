package ru.reliabletech.kotlin.multiplatform.web.domain

/**
 * UUID common type
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
expect class UUID

/**
 * UUID factory
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
expect fun randomUUID() : UUID