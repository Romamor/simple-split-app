plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
// settings.gradle.kts
rootProject.name = "split-expenses-app"

include(":backend")
include(":android-app")
