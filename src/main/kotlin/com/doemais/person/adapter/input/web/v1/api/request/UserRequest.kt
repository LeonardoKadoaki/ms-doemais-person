package com.doemais.person.adapter.input.web.v1.api.request

import com.doemais.person.application.domain.UserGender
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)//remover
data class UserRequest(
    val userId: Int = 0,
    val name: String,
    val nickName: String,
    val document: String,
    val birthDate: LocalDate,
    val registerDate: LocalDate,
    val phoneNumber: String,
    val gender: UserGender,
    val aboutYou: String? = null,
    val profilePic: String
)