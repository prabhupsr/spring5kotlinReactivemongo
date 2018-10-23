package com.pr.projectpoc.service

import com.pr.projectpoc.model.User
import com.pr.projectpoc.repo.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class UserServiceImpl(var userRepository: UserRepository) : UserService {

    override fun save(user: User) = userRepository.save(user)

    override fun findAll() = userRepository.findAll()

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun save(users: Flux<User>) = userRepository.saveAll(users)
}