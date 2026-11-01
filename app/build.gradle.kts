plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.jarvis.switchengine"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.jarvis.switchengine"
        minSdk = 26
        targetSdk = 35
        versionCode = 2
        versionName = "0.1.1-prototype"
        ndk { abiFilters += listOf("arm64-v8a") }
        externalNativeBuild {
            cmake { cppFlags += listOf("-std=c++17") }
        }
    }

    externalNativeBuild {
        cmake { path = file("src/main/cpp/CMakeLists.txt") }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
