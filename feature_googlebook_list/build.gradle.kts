plugins {
    id("toygooglebook.android.library")
    id("toygooglebook.android.library.compose")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}


dependencies {
    implementation(project(":core-ui"))
    implementation(project(":core-common"))
    implementation(project(":core-navigation"))
    implementation(project(":core-model"))
    implementation(project(":core-data"))

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.lifecycle.viewModelCompose)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.landscapist.coil)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

}