package com.pr.projectpoc.helper

import com.pr.projectpoc.extension.serverResponse
import org.reactivestreams.Publisher

class ServerResponseHelper {

    companion object {
        fun <T> response(cls:Class<T>,f:()->Publisher<T>) = f().serverResponse(cls)
    }

}