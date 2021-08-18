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

//    @Size(min = 1, max = 70)
    @Column(nullable = false, length = 70)
    val name: String,

//    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30, unique = true)
    val nickname: String,

//    @Size(min = 11, max = 11)
    @Column(nullable = false, length = 11, unique = true)
    val document: String,

//    @Past(message = "A data de nascimento não pode ser maior ou igual a data atual")
    @Column(nullable = false)
    val birthDate: LocalDate,

    @Column(nullable = false)
    val registerDate: LocalDate,

    @Column(unique = true, length = 14)
    val phoneNumber: String,

    @Column(nullable = false, length = 10)
    val gender: UserGender,

//    @Size(min = 0, max = 300, message = "O texto deve conter no máximo 300 caracteres")
    @Column(nullable = true, length = 300)
    val aboutYou: String? = null,

    @Column(nullable = true, length = 600)
    val profilePic: String
) {
}