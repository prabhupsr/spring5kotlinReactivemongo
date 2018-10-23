package com.pr.projectpoc.service

import com.pr.projectpoc.model.User
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {
    fun findAll(): Flux<User>
    fun save(users: Flux<User>): Flux<User>
    fun findByEmail(id: String): Mono<User>
    fun save(user: User): Mono<User>
}