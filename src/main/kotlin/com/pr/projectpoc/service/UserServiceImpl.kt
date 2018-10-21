package com.pr.projectpoc.service

import com.pr.projectpoc.model.UserDetails
import com.pr.projectpoc.repo.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserServiceImpl(var userRepository: UserRepository) : UserService {

    override fun findAll() = userRepository.findAll()

    override fun findById(id: Long) = userRepository.findById(id)

    override fun save(users: Flux<UserDetails>) = userRepository.saveAll(users)
}