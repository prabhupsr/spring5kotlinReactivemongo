package com.pr.projectpoc.extension

import org.reactivestreams.Publisher
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse

fun <T> Publisher<T>.serverResponse(cls: Class<T>) = ServerResponse.ok()
        .contentType(MediaType.APPLICATION_STREAM_JSON)
        .body(this, cls)
