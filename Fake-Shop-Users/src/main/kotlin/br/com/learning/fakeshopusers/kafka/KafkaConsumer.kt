package br.com.learning.fakeshopusers.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer {

    @KafkaListener(topics = ["fake-shop-login"], groupId = "fake-shop")
    fun consume(message: String) {
        println("Consumed message: $message")
    }
}