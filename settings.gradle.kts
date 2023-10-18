pluginManagement {
    repositories {
        includeBuild("build-logic")
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
rootProject.name = "AndroidTemplate"
include(":app")
include(":core:database")
include(":core:designsystem")
include(":core:model")
include(":feature:mainscreen")
include(":core:network")
include(":core:datastore")
include(":core:data")
include(":core:domain")
include(":core:common")
include(":core:testing")
include(":core:ui")
include(":core:worker")
//include(":app:baselineprofile")
include(":app:baselineprofile")
