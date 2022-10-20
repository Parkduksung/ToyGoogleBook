plugins {
    id("toygooglebook.android.library")
    id("toygooglebook.android.library.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.example.core_testing.AppTestRunner"
    }
}


dependencies {
    implementation(project(":core-ui"))
    implementation(project(":core-common"))
    implementation(project(":core-navigation"))
    implementation(project(":core-model"))
    implementation(project(":core-data"))
    implementation(project(":core-data-test"))
    implementation(project(":core-testing"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.landscapist.coil)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    api(libs.hilt.android.testing)

    implementation(libs.retrofit.gson)
}