package com.wrapify.buildsrc

object Versions {
    const val ktlint = "0.40.0"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha12"
    const val material = "com.google.android.material:material:1.1.0"

    object Spotify {
        private const val version = "1.1.0"
        const val auth = "com.spotify.android:auth:$version"
    }

    object Accompanist {
        private const val version = "0.6.0"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
        const val insets = "dev.chrisbanes.accompanist:accompanist-insets:$version"
    }

    object Kotlin {
        private const val version = "1.4.30"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Navigation {
        private const val version = "1.0.0-alpha09"
        const val navigation = "androidx.navigation:navigation-compose:$version"
    }

    object Coroutines {
        private const val version = "1.4.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object DaggerHilt {
        private const val dagger_hilt_version = "2.28.3-alpha"
        private const val androidx_hilt_version = "1.0.0-alpha02"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$dagger_hilt_version"
        const val hilt = "com.google.dagger:hilt-android:$dagger_hilt_version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$dagger_hilt_version"
        const val androidXHilt = "androidx.hilt:hilt-lifecycle-viewmodel:$androidx_hilt_version"
        const val androidXHiltCompiler = "androidx.hilt:hilt-compiler:$androidx_hilt_version"
    }

    object Network {
        private const val retrofit_version = "2.9.0"
        private const val okHttp_version = "4.7.2"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
        const val converter = "com.squareup.retrofit2:converter-gson:$retrofit_version"
        const val okhttp = "com.squareup.okhttp3:okhttp:$okHttp_version"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$okHttp_version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-rc01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-beta01"

        object Compose {
            const val snapshot = ""
            const val version = "1.0.0-beta01"

            const val foundation = "androidx.compose.foundation:foundation:${version}"
            const val layout = "androidx.compose.foundation:foundation-layout:${version}"
            const val ui = "androidx.compose.ui:ui:${version}"
            const val uiUtil = "androidx.compose.ui:ui-util:${version}"
            const val runtime = "androidx.compose.runtime:runtime:${version}"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val material = "androidx.compose.material:material:${version}"
            const val animation = "androidx.compose.animation:animation:${version}"
            const val tooling = "androidx.compose.ui:ui-tooling:${version}"
            const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha03"
        }

        object Lifecycle {
            const val viewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha02"
        }

        object ConstraintLayout {
            const val constraintLayoutCompose =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"
        }
    }
}