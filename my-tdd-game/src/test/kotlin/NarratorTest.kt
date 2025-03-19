import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.example.Narrator
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class NarratorTest : StringSpec({

    "should print two intro messages to stdout" {
        // Capture stdout
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))
        val narrator = Narrator()

        // Run
        narrator.narrate()
        narrator.narrate()

        // Reset stdout
        System.setOut(originalOut)

        // Get output as string
        val output = outputStream.toString().trim()

        // Assert both lines are present
        output shouldContain "Welcome to this TDD Game!"
        output shouldContain "Let the adventure begin!"
    }

    "should read user input" {
        // Provide fake user input (simulate typing "Alice")
        val input = "Alice\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val originalIn = System.`in`
        System.setIn(inputStream)

        // Optionally capture stdout if you want to check prompt
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        // Act
        val userInput = Narrator().ask("What is your name?")

        // Reset System.in and System.out
        System.setIn(originalIn)
        System.setOut(originalOut)

        // Assert
        userInput shouldBe "Alice"
    }
})
