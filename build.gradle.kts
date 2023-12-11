plugins {
    kotlin("jvm") version "1.9.21"
}

group = "cc.worldmandia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.dv8tion:JDA:5.0.0-beta.18")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.8.0-RC")


    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}