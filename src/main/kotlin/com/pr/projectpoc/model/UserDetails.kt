package com.pr.projectpoc.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class UserDetails(var name:String, var dateOfBirth:Date, @Id var phoneNumber:Long, var email: String)