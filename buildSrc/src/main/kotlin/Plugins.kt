

object Plugins {
    const val gradle = "com.android.tools.build:gradle:7.0.0-beta03"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.Kotlin.version}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Dependencies.Hilt.version}"

    object Spotless {
        const val plugin = "com.diffplug.spotless"
        const val version = "5.9.0"
    }
}
