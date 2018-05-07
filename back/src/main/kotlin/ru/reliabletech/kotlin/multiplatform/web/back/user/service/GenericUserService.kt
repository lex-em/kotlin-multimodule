package ru.reliabletech.kotlin.multiplatform.web.back.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.reliabletech.kotlin.multiplatform.web.back.exception.NotFoundException
import ru.reliabletech.kotlin.multiplatform.web.back.exception.UnauthorizedException
import ru.reliabletech.kotlin.multiplatform.web.back.security.CommonUserDetailsService
import ru.reliabletech.kotlin.multiplatform.web.back.user.domain.User
import ru.reliabletech.kotlin.multiplatform.web.back.user.domain.UserMapper
import ru.reliabletech.kotlin.multiplatform.web.back.user.domain.UserRepository
import ru.reliabletech.kotlin.multiplatform.web.domain.UUID
import ru.reliabletech.kotlin.multiplatform.web.domain.randomUUID
import ru.reliabletech.kotlin.multiplatform.web.exception.PasswordNotMatchException
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserDto
import ru.reliabletech.kotlin.multiplatform.web.user.dto.UserRegistrationDto
import javax.transaction.Transactional

@Service
@Transactional
class GenericUserService(val commonUserDetailsService: CommonUserDetailsService,
                         val userRepository: UserRepository,
                         val userMapperKt: UserMapper,
                         val passwordEncoder: PasswordEncoder) : UserService {

    override fun registerUser(registrationDto: UserRegistrationDto): Unit {
        if (!registrationDto.isPasswordConfirmed()) {
            throw PasswordNotMatchException()
        }
        val user = User(randomUUID(), registrationDto.login, passwordEncoder.encode(registrationDto.password))
        userRepository.save(user)
    }

    override fun getCurrentUser(): UserDto {
        return commonUserDetailsService.getCurrentUserDetails()
                ?.let { userRepository.findByLogin(it.username) }
                ?.let(userMapperKt::toDto)
                ?: throw UnauthorizedException()

    }

    override fun getUser(id: UUID): UserDto {
        return userRepository.findById(id)
                .map(userMapperKt::toDto)
                .orElseThrow(::NotFoundException)
    }
}