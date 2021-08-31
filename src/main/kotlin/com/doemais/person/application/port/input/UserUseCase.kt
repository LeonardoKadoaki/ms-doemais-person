package com.doemais.person.application.port.input

import com.doemais.person.application.domain.User

interface UserUseCase {

    fun getUser(id: Int): User

    fun save(user: User): User

    fun update(user: User): User

    fun delete(id: Int)
}