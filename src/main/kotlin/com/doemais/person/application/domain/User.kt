package com.doemais.person.application.domain

import com.doemais.person.application.port.output.UserRepositoryPort
import com.doemais.person.application.validation.isValidCpf
import java.time.LocalDate
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class User(
    val userId: Int = 0,

    @field:Size(min = 1, max = 70, message = "Name must have 1 to 70 characters")
    val name: String = "",

    @field:Size(min = 1, max = 30, message = "Nickname must have 1 to 70 characters")
    val nickname: String = "",

    //    @Size(min = 11, max = 11)
    val document: String = "",

    //    @Past(message = "A data de nascimento não pode ser maior ou igual a data atual")
    val birthDate: LocalDate = LocalDate.parse("1900-01-01"),

    val registerDate: LocalDate = LocalDate.parse("1900-01-01"),

    val phoneNumber: String = "",

    val gender: UserGender = UserGender.OTHER,

    //    @Size(min = 0, max = 300, message = "Max 300 characters")
    val aboutYou: String? = null,

    val profilePic: String = ""
) {

    fun save(userRepositoryPort: UserRepositoryPort): User {
        this.validateData(userRepositoryPort)
        return userRepositoryPort.save(this)
    }

    fun update(userRepositoryPort: UserRepositoryPort): User{
        this.validateDocument()
        return userRepositoryPort.save(this)
    }

    fun delete(userRepositoryPort: UserRepositoryPort){
        userRepositoryPort.delete(this)
    }

    private fun validateData(userRepositoryPort: UserRepositoryPort){
        this.validateDocument()
        this.verifyDuplicatedRegister(userRepositoryPort)
    }

    private fun validateDocument(){
        if (!this.document.isValidCpf()){
            throw throw Exception("Invalid document")
        }
    }

    private fun verifyDuplicatedRegister(userRepositoryPort: UserRepositoryPort){
        val userByDocument = userRepositoryPort.findByDocument(this.document)
        val userByNickname = userRepositoryPort.findByNickname(this.nickname)
        val userByPhone = userRepositoryPort.findByPhoneNumber(this.phoneNumber)

        if (userByDocument != null){
            throw Exception("Document already registered")
        }

        if (userByNickname != null) {
            throw Exception("Nickname already registered")
        }

        if (userByPhone != null) {
            throw Exception("Phone number already registered")
        }
    }
}