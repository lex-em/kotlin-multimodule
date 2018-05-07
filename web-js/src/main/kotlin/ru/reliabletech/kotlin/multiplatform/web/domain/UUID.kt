package ru.reliabletech.kotlin.multiplatform.web.domain

import ext.js.npm.uuidv4

/**
 * UUID common type js realization
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
actual class UUID

/**
 * UUID factory js realization
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
actual fun randomUUID() : UUID = uuidv4()