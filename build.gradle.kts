// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
        classpath(Plugins.kotlinSerialization)
        classpath(Plugins.hilt)
    }
}

plugins {
    id(Plugins.Spotless.plugin) version (Plugins.Spotless.version)
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt")
        targetExclude("bin/**/*.kt")
        ktlint("0.40.0").userData(mapOf("disabled_rules" to "no-wildcard-imports"))
    }
}

tasks.named("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}