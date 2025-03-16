plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Clikt
    implementation("com.github.ajalt.clikt:clikt:5.0.3")
    // Kotest Runner
    testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
    // Mockk
    testImplementation("io.mockk:mockk:1.13.5")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}