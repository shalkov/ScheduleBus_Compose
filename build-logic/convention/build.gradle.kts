plugins {
    `kotlin-dsl`
}

group = "ru.shalkoff.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.tools.build.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    /**
     * Регистрация пользовательских плагинов
     */
    plugins {
        register("schedulebusAndroidApplication") {
            id = "schedulebus.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("schedulebusAndroidLibrary") {
            id = "schedulebus.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("schedulebusAndroidTest") {
            id = "schedulebus.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("schedulebusCompose") {
            id = "schedulebus.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}
