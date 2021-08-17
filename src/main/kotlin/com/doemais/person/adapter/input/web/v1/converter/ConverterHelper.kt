package com.doemais.person.adapter.input.web.v1.converter

import com.doemais.person.adapter.input.web.v1.api.request.UserRequest
import com.doemais.person.adapter.input.web.v1.api.response.UserResponse
import com.doemais.person.application.domain.User

fun UserRequest.toDomain(): User =
    User(
        userId = this.userId,
        name = this.name,
        nickName = this.nickName,
        document = this.document,
        birthDate = this.birthDate,
        registerDate = this.registerDate,
        phoneNumber = this.phoneNumber,
        gender = this.gender,
        aboutYou = this.aboutYou,
        profilePic = this.profilePic
    )

fun User.toResponse(): UserResponse =
    UserResponse(
        userId = this.userId,
        name = this.name,
        nickName = this.nickName,
        document = this.document,
        birthDate = this.birthDate,
        registerDate = this.registerDate,
        phoneNumber = this.phoneNumber,
        gender = this.gender,
        aboutYou = this.aboutYou,
        profilePic = this.profilePic
    )