package com.pr.projectpoc.handler

import com.pr.projectpoc.helper.ServerResponseHelper.Companion.response
import com.pr.projectpoc.model.UserDetails
import com.pr.projectpoc.service.UserService
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class UserHandler(var userService: UserService) {

    fun findAllUsers() = response(UserDetails::class.java) { userService.findAll() }

    fun findById(id: Long) = response(UserDetails::class.java) { userService.findById(id) }

    fun save(userDetails: Flux<UserDetails>) = response(Pair::class.java) { userService.save(userDetails).map { lt->Pair(lt.name,lt.phoneNumber) } }

}