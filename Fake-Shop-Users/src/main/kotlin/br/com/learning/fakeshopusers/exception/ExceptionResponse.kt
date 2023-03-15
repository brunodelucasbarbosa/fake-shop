package br.com.learning.fakeshopusers.exception

import java.util.Date

data class ExceptionResponse(
    private val timestamp: Date,
    private val message: String,
    private val details: String
)
