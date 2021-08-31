package com.doemais.person.adapter.output.mysql.entity

import com.doemais.person.application.domain.UserGender
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@Entity
@Table(name = "user")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int = 0,

    @Column(nullable = false, length = 70)
    val name: String,

    @Column(nullable = false, length = 30, unique = true)
    val nickname: String,

    @Column(nullable = false, length = 11, unique = true)
    val document: String,

    @Column(nullable = false)
    val birthDate: LocalDate,

    @Column(nullable = false)
    val registerDate: LocalDate,

    @Column(unique = true, length = 14)
    val phoneNumber: String,

    @Column(nullable = false, length = 10)
    val gender: UserGender,

    @Column(nullable = true, length = 300)
    val aboutYou: String? = null,

    @Column(nullable = true, length = 600)
    val profilePic: String
) {
}