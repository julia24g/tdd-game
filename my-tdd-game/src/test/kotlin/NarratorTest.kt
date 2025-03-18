import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldContain
import org.example.Narrator
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class NarratorTest : StringSpec({

    "should print intro message to stdout" {
        // Capture stdout
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        // Run command
        Narrator().narrate(emptyArray())

        // Reset stdout
        System.setOut(originalOut)

        // Assert output
        val output = outputStream.toString().trim()
        output shouldContain "Welcome to this TDD Game!"
    }

    "should print second intro message" {

    }

    "should read user input" {

    }
})
