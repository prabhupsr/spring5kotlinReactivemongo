package com.pr.projectpoc.config

import com.pr.projectpoc.handler.UserHandler
import com.pr.projectpoc.model.UserDetails
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.router


@Configuration
class RouterConfig {

    @Bean
    fun userApiRouter(userHandler: UserHandler) = router {
        "/users".nest {

            GET("/") { userHandler.findAllUsers() }

            GET("/{id}") { req -> userHandler.findById(req.pathVariable("id")?.toLong()) }

            POST("/") { req -> userHandler.save(req.bodyToFlux(UserDetails::class.java)) }
        }

        GET("/")  { userHandler.findAllUsers() }
    }

}



















/*@Bean
    fun beans() = beans {

        bean<UserHandler>()

        bean {
            router {
                "/userz".nest {
                    GET("/") { _ -> ref<UserHandler>().findAllUsers() }
                    GET("/{id}") { req -> ref<UserHandler>().findById(req.pathVariable("id")?.toLong()) }
                    POST("/") { req -> ref<UserHandler>().save(req.bodyToFlux(UserDetails::class.java)) }
                }
            }
        }
    }
*/
