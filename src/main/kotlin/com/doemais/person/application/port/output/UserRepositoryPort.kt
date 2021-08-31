package com.doemais.person.application.port.output

import com.doemais.person.application.domain.User

interface UserRepositoryPort {

    fun save(user: User): User

    fun findById(id: Int): User?

    fun findByDocument(document: String): User?

    fun findByNickname(nickname: String): User?

    fun findByPhoneNumber(phoneNumber: String): User?

    fun delete(user: User)
}