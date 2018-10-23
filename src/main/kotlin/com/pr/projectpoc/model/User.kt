package com.pr.projectpoc.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
class User(@Id val id: Long,
           var name: String,
           var dateOfBirth: LocalDate,
           val email: String,
           var phoneNumber: String,
           var password: String,
           var enabled: Boolean = false,
           var credentialsNonExpired: Boolean = true,
           var accountNonExpired: Boolean = true,
           var accountNonLocked: Boolean = true,
           var authorities: List<String> = listOf("ROLE_USERR")
)