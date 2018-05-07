package ru.reliabletech.kotlin.multiplatform.web.back.user.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.reliabletech.kotlin.multiplatform.web.back.user.service.UserService
import ru.reliabletech.kotlin.multiplatform.web.user.controller.UserController
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto
import java.util.*

/**
 * Backend realization of user operations controller
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Api(description = "User operations API")
@RestController
@RequestMapping("/user")
class GenericUserController(val userService: UserService) : UserController {

    @ApiOperation(value = "Get user",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = UserDto::class,
            nickname = "getUser",
            position = 0)
    @ApiResponses(
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 404, message = "Not found"))
    @GetMapping("{id}")
    override fun getUser(@PathVariable id: UUID): UserDto {
        return userService.getUser(id)
    }


    @ApiOperation(value = "Get current user(me)",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = UserDto::class,
            nickname = "getCurrentUser",
            position = 1)
    @ApiResponses(ApiResponse(code = 200, message = "OK"))
    @GetMapping("me")
    override fun getCurrentUser(): UserDto {
        return userService.getCurrentUser()
    }

}