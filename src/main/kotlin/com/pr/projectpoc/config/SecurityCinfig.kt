package com.pr.projectpoc.config

import com.pr.projectpoc.model.AuthUserDetails
import com.pr.projectpoc.repo.UserRepository
import com.pr.projectpoc.service.UserService
import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SecurityCinfig {

    @Bean
    fun passwordEncoder() = PasswordEncoderFactories.createDelegatingPasswordEncoder()!!

    @Bean
    fun userDetailsRepo(userService: UserService) =
            ReactiveUserDetailsService { userService.findByEmail(it).map { AuthUserDetails(it) } }

    @Bean
    fun mongoInit(userService: UserService,
                  userRepository: UserRepository,
                  passwordEncoder: PasswordEncoder,
                  @Value("\${encoder.prefix}")
                  encoderPrefix: String): SmartInitializingSingleton {

        return SmartInitializingSingleton {

            userService.findAll()
                    .filter { !it.password.startsWith(encoderPrefix) }
                    .doOnNext { it.password = passwordEncoder.encode(it.password) }
                    .flatMap { userService.save(it) }
                    .collectList()
                    .block()
        }
    }

}