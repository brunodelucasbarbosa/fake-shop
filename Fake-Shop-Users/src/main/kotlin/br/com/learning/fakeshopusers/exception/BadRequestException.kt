package br.com.learning.fakeshopusers.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.io.Serial

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequestException(message: String?) : RuntimeException(message) {
    companion object {
        @Serial
        private val serialVersionUID = 1L
    }
}
