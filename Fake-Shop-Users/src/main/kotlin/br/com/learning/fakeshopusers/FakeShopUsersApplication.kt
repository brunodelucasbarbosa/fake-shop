package br.com.learning.fakeshopusers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeShopUsersApplication

fun main(args: Array<String>) {
	runApplication<FakeShopUsersApplication>(*args)
}
