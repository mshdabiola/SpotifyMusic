@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.library.compose")
    //alias(libs.plugins.google.services)
}

android {
    namespace = "com.mshdabiola.designsystem"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }

}


dependencies {

    //implementation (project( ":model"))

    testImplementation(libs.junit4)

}