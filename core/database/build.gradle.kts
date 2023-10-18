@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
    id("mshdabiola.android.room")
}

android {
    namespace = "com.mshdabiola.database"


}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(project(":core:testing"))
    implementation(libs.paging.common)
    implementation(libs.paging.testing)

}