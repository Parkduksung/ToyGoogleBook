plugins {
    id("toygooglebook.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":core-common"))
    implementation(project(":core-model"))


    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.retrofit.gson)

    api(libs.junit4)
    api(libs.truth)
    api(libs.mockitoKotlin)
    api(libs.mockitoInline)
    api(libs.turbine)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)

    api(libs.androidx.compose.ui.test)
    api(libs.androidx.test.runner)

    debugApi(libs.androidx.compose.ui.testManifest)
    api(libs.hilt.android.testing)
}