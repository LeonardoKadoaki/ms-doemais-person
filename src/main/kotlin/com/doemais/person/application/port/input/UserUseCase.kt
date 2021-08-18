package com.doemais.person.application.port.input

import com.doemais.person.application.domain.User

interface UserUseCase {
    fun save(user: User): User
}