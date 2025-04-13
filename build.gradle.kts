// build.gradle.kts в корне проекта
plugins {
    val kotlinVersion = "2.1.20"
    val ktlintVersion = "12.2.0"
    kotlin("jvm") version kotlinVersion apply false
    kotlin("android") version kotlinVersion apply false
    id("org.jlleitschuh.gradle.ktlint") version ktlintVersion apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Более эффективная задача clean ?
// tasks.register("cleanAll") {
//     doLast {
//         allprojects {
//             delete(project.buildDir)
//         }
//     }
// }
