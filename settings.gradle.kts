pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ScheduleBus"
include(":app")
include(":data")
include(":domain")
include(":core:ui")
include(":core:util")
include(":core:testing")

include(":feature:main")
include(":feature:splash")
include(":feature:detail")

include(":test:navigation")
