package com.doemais.person.adapter.input.web.v1.controller

import com.doemais.person.adapter.input.web.v1.api.UserApi
import com.doemais.person.adapter.input.web.v1.api.request.UserRequest
import com.doemais.person.adapter.input.web.v1.api.response.UserResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController : UserApi{

    override fun getUser(userId: Int): UserResponse {
        return UserResponse()
    }

    override fun registerUser(userRequest: UserRequest) {
        TODO("Not yet implemented")
    }

    override fun updateUser(userRequest: UserRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: Int) {
        TODO("Not yet implemented")
    }
}