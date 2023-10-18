plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
}

android {
    namespace = "com.mshdabiola.common"
}
dependencies {

    implementation(platform(libs.firebase.bom))
    testImplementation(project(":core:testing"))
    implementation(libs.firebase.analytics)
}