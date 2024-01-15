@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.schedulebus.android.library)
    alias(libs.plugins.schedulebus.compose)
}

android {
    namespace = "ru.shalkoff.feature.main"
}

dependencies {
    implementation(project(":data"))
    implementation(project(":core:ui"))

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.hilt.navigation.compose)

    // Image Loader Async
    implementation(libs.coil.image.loader)
}