package ru.reliabletech.kotlin.multiplatform.web.domain

/**
 * UUID common type jvm realization
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
actual typealias UUID = java.util.UUID

/**
 * UUID factory jvm realization
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
actual fun randomUUID () : UUID = java.util.UUID.randomUUID()