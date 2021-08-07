import org.jetbrains.kotlin.konan.properties.Properties
import java.io.FileInputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")

}

fun Project.createPropertiesFrom(filename: String) : Properties {
    val props = rootProject.file(filename)
    return Properties().apply {  load(FileInputStream(props)) }
}

val spotifyProps = createPropertiesFrom("spotify.properties")
val keysProps = createPropertiesFrom("keys.properties")



fun com.android.build.api.dsl.BaseFlavor.buildConfigString(name: String, value: String) =
    buildConfigField("String", name, "\"$value\"")

android {
    compileSdk = BuildConfig.compileSdk
    buildToolsVersion = BuildConfig.buildTools
    flavorDimensions.addAll(Dimensions.all)

    defaultConfig {
        versionCode = 1
        versionName = "0.0.1"
        applicationId = "cz.levinzonr.spotie"

        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    productFlavors {
        create(Flavours.production) {
            dimension = Dimensions.environment
            buildConfigString("CLIENT_ID",spotifyProps.getProperty("client_id"))
            buildConfigString("CLIENT_SECRET", spotifyProps.getProperty("client_secret"))
            buildConfigString("REDIRECT_URI", spotifyProps.getProperty("redirect_uri"))
            buildConfigString("API_URL", "https://api.spotify.com/")
            buildConfigString("API_AUTH_URL", "https://accounts.spotify.com/")
            buildConfigString("LYRICS_API_KEY", keysProps.getProperty("API_KEY"))
            buildConfigString("LYRICS_BASE_URL", "https://api.happi.dev/")
        }
        create(Flavours.staging) {
            applicationIdSuffix = ".staging"
            dimension = Dimensions.environment
            buildConfigString("API_URL", "https://reqres.in/api/")

        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = Dependencies.Kotlin.version
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }

    packagingOptions {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources.excludes.add("/META-INF/AL2.0")
        resources.excludes.add("/META-INF/LGPL2.1")
    }
}

dependencies {

    implementation(Dependencies.Kotlin.serialization)

    // common android
    implementation(Dependencies.Android.ktx)
    implementation(Dependencies.Android.compat)
    implementation(Dependencies.Android.material)

    // compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.lifecycle)
    implementation(Dependencies.Compose.livedata)

    // accompanist
    implementation(Dependencies.coil)
    implementation(Dependencies.Accompanist.pager)

    implementation(Dependencies.spotifyAuth)
    implementation(project(":spotify-remote"))
    implementation("com.google.code.gson:gson:2.8.7")


    implementation(Dependencies.Navigation.compose)
    implementation(Dependencies.Navigation.hilt)

    implementation(Dependencies.SafeRouting.core)
    kapt(Dependencies.SafeRouting.compiler)

    implementation(Dependencies.roxie)

    // lifecycle
    implementation(Dependencies.Lifecycle.runtime)

    // hilt & dagger
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // networking
    implementation(platform(Dependencies.OkHttp.bom))
    implementation(Dependencies.OkHttp.okhttp)
    implementation(Dependencies.OkHttp.loggingInterceptor)
    implementation(Dependencies.OkHttp.retrofit)
    implementation(Dependencies.OkHttp.converter)


    implementation(Dependencies.timber)

    implementation(Dependencies.DataStore.preferences)
    implementation(Dependencies.DataStore.typed)
    implementation(Dependencies.Android.prefs)

    // testing
    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.junitAndroid)
    androidTestImplementation(Dependencies.Testing.espresso)
    androidTestImplementation(Dependencies.Testing.junitCompose)
}