import com.mshdabiola.app.BuildType

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.application")
    id("mshdabiola.android.application.compose")
    //id("mshdabiola.android.application.flavor")
    id("mshdabiola.android.hilt")
    id("mshdabiola.android.application.firebase")
    alias(libs.plugins.androidx.baselineprofile)
    alias(libs.plugins.android.application)

}

android {
    namespace = "com.mshdabiola.tempapp"

    defaultConfig {
        applicationId = "com.mshdabiola.tempapp"
        testInstrumentationRunner = "com.mshdabiola.testing.TestRunner"
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = BuildType.DEBUG.applicationIdSuffix
            versionNameSuffix = BuildType.DEBUG.versionNameSuffix
        }
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            // Todo: comment code before release
//            signingConfig = signingConfigs.getByName("debug")
            applicationIdSuffix = BuildType.RELEASE.applicationIdSuffix
            versionNameSuffix = BuildType.RELEASE.versionNameSuffix
        }
        val benchmark by creating {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            //  FIXME enabling minification breaks access to demo backend.
            isMinifyEnabled = false
            applicationIdSuffix = BuildType.BENCHMARK.applicationIdSuffix
            versionNameSuffix = BuildType.BENCHMARK.versionNameSuffix
        }
    }


    packagingOptions {
        excludes += "/META-INF/AL2.0"
        excludes += "/META-INF/LGPL2.1"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(project(":core:designsystem"))
    implementation(project(":feature:mainscreen"))
    implementation(project(":core:worker"))
    implementation(libs.androidx.profileinstaller)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.timber)
    androidTestImplementation(project(":core:testing"))
    "baselineProfile"(project(":app:baselineprofile"))
    //"baselineProfile"(project(":app:baselineprofile"))

}
