plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
}

android {
    namespace = "com.mshdabiola.worker"
}
dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:data"))
   // implementation(project(":core:datastore"))

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.startup)
    implementation(libs.androidx.work.ktx)
    implementation(libs.hilt.ext.work)

    testImplementation(project(":core:testing"))
    androidTestImplementation(project(":core:testing"))

    //kapt(libs.hilt.ext.compiler)
    implementation(libs.kotlinx.serialization.json)
    androidTestImplementation(libs.androidx.work.testing)
    androidTestImplementation(libs.hilt.android.testing)
}
