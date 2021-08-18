package com.doemais.person.application.service

import com.doemais.person.application.domain.User
import com.doemais.person.application.port.input.UserUseCase
import com.doemais.person.application.port.output.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepositoryPort: UserRepositoryPort
): UserUseCase {

    override fun save(user: User): User {
        return user.save(userRepositoryPort)
    }
}