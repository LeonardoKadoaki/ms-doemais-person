package com.doemais.person.adapter.input.web.v1.api

import com.doemais.person.adapter.input.web.v1.api.request.UserRequest
import com.doemais.person.adapter.input.web.v1.api.response.UserResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.NotBlank

@RequestMapping("/v1/user", produces = [MediaType.APPLICATION_JSON_VALUE])
@Validated
@Api(tags = ["User"])
interface UserApi {

    @ApiOperation("get user information by id")
    @GetMapping("/{userId}")
    fun getUser(@PathVariable(required = true) @NotBlank userId: Int): UserResponse//substituir pelo id do token futuramente

    @PostMapping
    fun registerUser(@RequestBody userRequest: UserRequest): UserResponse

    @PutMapping
    fun updateUser(@RequestBody userRequest: UserRequest)

    @DeleteMapping("/{userId}")
    fun deleteUser(@PathVariable(required = true) @NotBlank userId: Int)//substituir pelo id do token futuramente
}