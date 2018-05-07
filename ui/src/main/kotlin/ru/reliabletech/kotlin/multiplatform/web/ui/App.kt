package ru.reliabletech.kotlin.multiplatform.web.ui

import ru.reliabletech.kotlin.multiplatform.web.domain.UUID
import ru.reliabletech.kotlin.multiplatform.web.domain.randomUUID
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto
import kotlin.browser.document

// Prevent dead code elimination optimization remove this module
fun main(args: Array<String>) {
    start()
}

@JsName("start")
fun start(development: Boolean = false) {
    val element = document.createElement("div")
    val content = document.createTextNode("Development: $development")
    element.appendChild(content)

    document.body?.appendChild(element)
    val id : UUID = randomUUID()
    console.log(UserDto(id, "123"))
}