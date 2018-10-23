package com.pr.projectpoc.handler

import com.pr.projectpoc.helper.ServerResponseHelper.Companion.response
import com.pr.projectpoc.model.User
import com.pr.projectpoc.service.UserService
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class UserHandler(var userService: UserService) {

    fun findAllUsers() = response(User::class.java) { userService.findAll() }

    fun findByEmail(id: String) = response(User::class.java) { userService.findByEmail(id) }

    fun save(user: Flux<User>) =
            response(User::class.java) { userService.save(user) }

    fun findAllBasic() =
            response(Map::class.java)
            {
                userService.findAll()
                        .map { lt -> mapOf("name" to lt.name, "email" to lt.email, "phone" to lt.phoneNumber) }
            }

}