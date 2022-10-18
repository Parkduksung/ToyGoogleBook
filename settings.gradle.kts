pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ToyGoogleBook"
include(":app")
include(":core-ui")
include(":core-common")
include(":core-navigation")
include(":core-network")
include(":core-model")
include(":core-data")
include(":feature_googlebook_list")
