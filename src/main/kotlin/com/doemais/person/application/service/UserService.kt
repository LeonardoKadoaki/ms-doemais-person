package com.doemais.person.application.service

import com.doemais.person.application.domain.User
import com.doemais.person.application.port.input.UserUseCase
import com.doemais.person.application.port.output.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepositoryPort: UserRepositoryPort
) : UserUseCase {

    override fun getUser(id: Int): User {
        return userRepositoryPort.findById(id) ?: throw Exception("User not found")
    }

    override fun save(user: User): User {
        return user.save(userRepositoryPort)
    }

    override fun update(user: User): User {
        return user.update(userRepositoryPort)
    }

    override fun delete(id: Int) {
        val user = this.getUser(id)
        user.delete(userRepositoryPort)
    }

}