package com.pr.projectpoc.config

import com.pr.projectpoc.handler.UserHandler
import com.pr.projectpoc.model.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router


@Configuration
class RouterConfig {

    @Bean
    fun userApiRouter(userHandler: UserHandler) = router {
        "/users".nest {
            GET("/") { userHandler.findAllUsers() }
            GET("/{email}") { req -> userHandler.findByEmail(req.pathVariable("email")) }
            POST("/") { req -> userHandler.save(req.bodyToFlux(User::class.java)) }
        }
        GET("/") { userHandler.findAllBasic() }
    }
}
