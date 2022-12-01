import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    jacoco
}

group = "com.github.spork"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks.test {
    reports {
        junitXml.required.set(true)
        junitXml.isEnabled = true
    }
}

jacoco {
    toolVersion = "0.8.7"
}
tasks.withType<JacocoReport> {
    reports {
        xml.required.set(true)
        xml.isEnabled = true
        csv.required.set(true)
        csv.isEnabled = true
        html.required.set(true)
        html.isEnabled = true
    }

    val excludes = listOf(
        "**/*Test*.*",
        "**/actions/*.*",
        "**/core/*.*",
        "**/markers/*.*",
        "**/services/**/*.*",
        "**/toolwindow/*.*",
        "**/utils/*.*"
    )

    val javaClasses = fileTree("$buildDir/classes/java/main") { exclude(*excludes.toTypedArray()) }
    val kotlinClasses = fileTree("$buildDir/classes/kotlin/main") { exclude(*excludes.toTypedArray()) }
    classDirectories.from(javaClasses, kotlinClasses)
    sourceDirectories.from(
        "$project.projectDir/src/main/java",
        "$project.projectDir/src/main/kotlin",
        "$buildDir/generated/source/kapt/test"
    )

    executionData("${project.buildDir}/jacoco/test.exec")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}