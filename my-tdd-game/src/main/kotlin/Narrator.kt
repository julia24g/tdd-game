package org.example

class Narrator {
    private val introMessages = arrayOf("Welcome to this TDD Game!", "Let the adventure begin!")
    private var currentIntroMessage = 0

    fun ask(prompt: String): String {
        println("$prompt ")
        return readlnOrNull() ?: ""
    }

    fun narrate() {
        println(introMessages[currentIntroMessage])
        currentIntroMessage += 1
    }
}