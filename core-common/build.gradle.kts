plugins {
    id("toygooglebook.android.library")
    kotlin("kapt")
}


dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}