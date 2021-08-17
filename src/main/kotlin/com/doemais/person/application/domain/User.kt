package com.doemais.person.application.domain

import java.time.LocalDate

data class User (
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
        ) {

}