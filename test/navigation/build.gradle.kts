@Suppress("DSL_SCOPE_VIOLATION") // Remove when fixed https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.schedulebus.android.test)
}

android {
    namespace = "ru.shalkoff.test.navigation"
    targetProjectPath = ":app"
}

dependencies {
    implementation(project(":app"))
    implementation(project(":core:testing"))
    implementation(project(":data"))
    implementation(project(":feature:main"))
    implementation(project(":feature:splash"))
}
