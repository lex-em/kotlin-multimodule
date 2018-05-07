package ru.reliabletech.kotlin.multiplatform.web.back.user.domain;

import org.mapstruct.Mapper;
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto;

/**
 * Mapping operations for [User]
 *
 * Created by Alexandr Emelyanov<mr.lex91@gmail.com>
 */
@Mapper(componentModel = "spring")
interface UserMapper {

    fun toDto(user: User): UserDto
}
