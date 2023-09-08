@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.sample.android.application)
    alias(libs.plugins.sample.compose)
}

android {
    namespace = "ru.shalkoff"

    defaultConfig {
        applicationId = "ru.shalkoff.schedulebus"
    }

   // dynamicFeatures += setOf(":dynamic")
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":feature:main"))
    implementation(project(":feature:splash"))

    // Core Android dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Arch Components
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)

    // Compose
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)

    //implementation(libs.google.play.feature.delivery)
}