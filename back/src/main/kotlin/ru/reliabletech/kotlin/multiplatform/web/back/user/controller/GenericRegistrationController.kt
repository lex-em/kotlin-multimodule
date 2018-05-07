package ru.reliabletech.kotlin.multiplatform.web.back.user.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.reliabletech.kotlin.multiplatform.web.back.user.service.UserService
import ru.reliabletech.kotlin.multiplatform.web.user.controller.RegistrationController
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserRegistrationDto

/**
 * Backend realization of registration controller
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Api(description = "Registration API")
@RestController
class GenericRegistrationController(val userService: UserService) : RegistrationController {

    @ApiOperation(value = "Registration action",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            nickname = "register",
            position = 0)
    @ApiResponses(
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 400, message = "Registration error"))
    @PostMapping("register", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE])
    override fun register(@RequestBody registrationData: UserRegistrationDto) {
        return userService.registerUser(registrationData)
    }

}