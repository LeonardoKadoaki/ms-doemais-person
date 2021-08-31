package com.doemais.person.adapter.input.web.v1.controller

import com.doemais.person.adapter.input.web.v1.api.UserApi
import com.doemais.person.adapter.input.web.v1.api.request.UserRequest
import com.doemais.person.adapter.input.web.v1.api.response.UserResponse
import com.doemais.person.adapter.input.web.v1.converter.toDomain
import com.doemais.person.adapter.input.web.v1.converter.toResponse
import com.doemais.person.application.port.input.UserUseCase
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userUseCase: UserUseCase
): UserApi{

    override fun getUser(userId: Int): UserResponse {
        return userUseCase.getUser(userId).toResponse()
    }

    override fun registerUser(userRequest: UserRequest): UserResponse {
        return userUseCase.save(userRequest.toDomain()).toResponse()
    }

    override fun updateUser(userRequest: UserRequest): UserResponse {
        return userUseCase.update(userRequest.toDomain()).toResponse()
    }

    override fun deleteUser(userId: Int) {
        userUseCase.delete(userId)
    }
}