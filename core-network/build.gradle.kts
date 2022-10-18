plugins {
    id("toygooglebook.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":core-model"))
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)
}
