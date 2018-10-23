package com.pr.projectpoc.repo

import com.pr.projectpoc.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono

interface UserRepository : ReactiveMongoRepository<User, Long> {
    fun findByEmail(email: String): Mono<User>
}