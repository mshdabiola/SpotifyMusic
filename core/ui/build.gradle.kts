plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.library.compose")
}

android {
    namespace = "com.mshdabiola.ui"
}
dependencies {
    implementation(libs.kotlinx.collection.immutable)
}