package com.pr.projectpoc.service

import com.pr.projectpoc.model.UserDetails
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserService {
    fun findAll(): Flux<UserDetails>
    fun save(users: Flux<UserDetails>): Flux<UserDetails>
    fun findById(id: Long): Mono<UserDetails>
}