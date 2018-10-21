package com.pr.projectpoc.repo

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import com.pr.projectpoc.model.UserDetails
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:ReactiveMongoRepository<UserDetails,Long>