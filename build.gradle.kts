// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.tools.build.gradle.plugin)
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.hilt.gradle.plugin)
    }
}
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply true
    alias(libs.plugins.schedulebus.android.application) apply false
    alias(libs.plugins.schedulebus.android.library) apply false
    alias(libs.plugins.schedulebus.android.test) apply false
    alias(libs.plugins.schedulebus.compose) apply false
}
true // Needed to make the Suppress annotation work for the plugins block