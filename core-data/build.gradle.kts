plugins {
    id("toygooglebook.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":core-network"))
    implementation(project(":core-model"))
    implementation(project(":core-common"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
