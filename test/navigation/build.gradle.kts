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
    implementation(project(":domain"))
    implementation(project(":feature:main"))
    implementation(project(":feature:splash"))

    //Ktor Client (поправить зависимости, чтобы не было дублирования с модулем data)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.json)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.content.negotiation)
}
