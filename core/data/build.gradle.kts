plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
}

android {
    namespace = "com.mshdabiola.data"
}
dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:database"))
    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    testImplementation(project(":core:testing"))
    implementation(libs.paging.runtime)
    implementation(libs.paging.common)
}