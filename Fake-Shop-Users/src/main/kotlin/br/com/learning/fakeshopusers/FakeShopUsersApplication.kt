package br.com.learning.fakeshopusers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka


@SpringBootApplication
@EnableKafka
class FakeShopUsersApplication

fun main(args: Array<String>) {
	runApplication<FakeShopUsersApplication>(*args)
}
