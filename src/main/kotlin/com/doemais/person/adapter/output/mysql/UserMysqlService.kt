package com.doemais.person.adapter.output.mysql

import com.doemais.person.adapter.output.mysql.converter.toDomain
import com.doemais.person.adapter.output.mysql.converter.toEntity
import com.doemais.person.adapter.output.mysql.repository.UserRepository
import com.doemais.person.application.domain.User
import com.doemais.person.application.port.output.UserRepositoryPort
import org.springframework.stereotype.Service

@Service
class UserMysqlService(
    private val userRepository: UserRepository
) : UserRepositoryPort {

    override fun save(user: User): User = userRepository.save(user.toEntity()).toDomain()

    override fun findById(id: Int): User? {
        return userRepository.findUserEntityByUserId(id)?.toDomain()
    }

    override fun findByDocument(document: String): User? {
        return userRepository.findByDocument(document)?.toDomain()
    }

    override fun findByNickname(nickname: String): User? {
        return userRepository.findByNickname(nickname)?.toDomain()
    }

    override fun findByPhoneNumber(phoneNumber: String): User? {
        return userRepository.findByPhoneNumber(phoneNumber)?.toDomain()
    }

    override fun delete(user: User) {
        return userRepository.delete(user.toEntity())
    }

}