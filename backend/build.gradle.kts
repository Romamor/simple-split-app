// backend/build.gradle.kts
plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.7.20"
    id("org.jlleitschuh.gradle.ktlint")
    id("io.ktor.plugin") version "2.2.1"
}

group = "com.splitexpenses"
version = "0.0.1"

repositories {
    mavenCentral()
}

val ktorVersion = "2.2.1"
val exposedVersion = "0.41.1"
val postgresVersion = "42.5.1"
val hikariVersion = "5.0.1"
val logbackVersion = "1.4.5"
val flywayVersion = "9.8.1"

dependencies {
    // Ktor server
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-server-auth:$ktorVersion")
    implementation("io.ktor:ktor-server-auth-jwt:$ktorVersion")

    // Database
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
    implementation("org.postgresql:postgresql:$postgresVersion")
    implementation("com.zaxxer:HikariCP:$hikariVersion")
    implementation("org.flywaydb:flyway-core:$flywayVersion")

    // Logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    // Testing
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host:$ktorVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    test {
        useJUnitPlatform()
    }
}

ktor {
    fatJar {
        archiveFileName.set("backend-fat.jar")
    }
}
