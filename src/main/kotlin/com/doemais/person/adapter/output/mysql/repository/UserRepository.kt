package com.doemais.person.adapter.output.mysql.repository

import com.doemais.person.adapter.output.mysql.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Int> {

    fun findByDocument(document: String): UserEntity?

    fun findByNickname(nickname: String): UserEntity?

    fun findByPhoneNumber(phoneNumber: String): UserEntity?
}