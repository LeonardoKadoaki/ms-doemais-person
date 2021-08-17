package com.doemais.person.adapter.input.web.v1.api.response

import com.doemais.person.application.domain.UserGender
import java.time.LocalDate

data class UserResponse(
    val userId: Int = 0,
    val name: String = "",
    val nickName: String = "",
    val document: String = "",
    val birthDate: LocalDate = LocalDate.parse("1900-01-01"),
    val registerDate: LocalDate = LocalDate.parse("1900-01-01"),
    val phoneNumber: String = "",
    val gender: UserGender = UserGender.OTHER,
    val aboutYou: String? = null,
    val profilePic: String = ""
)