package com.claros.notes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class NotesApplication {
	@GetMapping("/")
	fun index(): String {
		return "Olá Mundo!";
	}
}

fun main(args: Array<String>) {
	runApplication<NotesApplication>(*args)
}