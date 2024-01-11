@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.schedulebus.android.library)
    alias(libs.plugins.schedulebus.compose)
}

android {
    namespace = "ru.shalkoff.core.ui"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)

    //Bottom Navigation Bar
    implementation(libs.animated.navigation.bar)
}