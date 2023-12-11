package com.example.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Message(val text: String)

@RestController
@RequestMapping("/api/messages")
class MessageController {

    @GetMapping
    fun getMessages(): List<Message> {
        return listOf(Message("Hello"), Message("Message one"), Message("Message two"))
    }

    @PostMapping
    fun createMessage(@RequestBody message: Message): Message {
        return message
    }
}
