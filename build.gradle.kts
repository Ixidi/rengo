plugins {
    kotlin("jvm") version Versions.kotlin apply false
}

allprojects {

    group = "xyz.ixidi"
    version = "1.0-SNAPSHOT"

}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

}