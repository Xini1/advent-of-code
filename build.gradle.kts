plugins {
    kotlin("jvm") version "1.5.10"
}

group = "com.adventofcode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.assertj:assertj-core:3.21.0")
}

tasks.compileKotlin {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.majorVersion
    }
}

tasks.compileTestKotlin {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.majorVersion
    }
}

tasks.test {
    useJUnitPlatform()
}