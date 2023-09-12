@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.schedulebus.android.library)
    alias(libs.plugins.schedulebus.compose)
}

android {
    namespace = "ru.shalkoff.feature.splash"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:util"))
    implementation(project(":data"))

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.hilt.navigation.compose)

    //Lottie Animation
    implementation(libs.lottie.animation.compose)
}