package br.com.learning.fakeshopusers.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(message: String) {
        this.kafkaTemplate.send("fake-shop-login", message)
    }
}