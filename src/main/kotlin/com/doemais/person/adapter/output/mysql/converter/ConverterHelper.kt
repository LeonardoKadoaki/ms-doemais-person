package com.doemais.person.adapter.output.mysql.converter

import com.doemais.person.adapter.output.mysql.entity.UserEntity
import com.doemais.person.application.domain.User

fun User.toEntity(): UserEntity =
    UserEntity(
        userId = this.userId,
        name = this.name,
        nickname = this.nickname,
        document = this.document,
        birthDate = this.birthDate,
        registerDate = this.registerDate,
        phoneNumber = this.phoneNumber,
        gender = this.gender,
        aboutYou = this.aboutYou,
        profilePic = this.profilePic
    )

fun UserEntity.toDomain(): User =
    User(
        userId = this.userId,
        name = this.name,
        nickname = this.nickname,
        document = this.document,
        birthDate = this.birthDate,
        registerDate = this.registerDate,
        phoneNumber = this.phoneNumber,
        gender = this.gender,
        aboutYou = this.aboutYou,
        profilePic = this.profilePic
    )