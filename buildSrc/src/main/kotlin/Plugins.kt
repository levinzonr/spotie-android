

object Plugins {
    const val gradle = "com.android.tools.build:gradle:4.2.1"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Dependencies.Kotlin.version}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.Kotlin.version}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Hilt.version}"

    object Spotless {
        const val plugin = "com.diffplug.spotless"
        const val version = "5.9.0"
    }
}
